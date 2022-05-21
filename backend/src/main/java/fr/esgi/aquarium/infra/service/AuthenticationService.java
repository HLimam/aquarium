package fr.esgi.aquarium.infra.service;

import fr.esgi.aquarium.domain.enumeration.AuthProvider;
import fr.esgi.aquarium.domain.enumeration.Role;
import fr.esgi.aquarium.domain.exception.*;
import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.domain.repository.UserRepository;
import fr.esgi.aquarium.infra.security.JwtProvider;
import fr.esgi.aquarium.infra.security.oauth2.OAuth2UserInfo;
import fr.esgi.aquarium.infra.web.response.CaptchaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final RestTemplate restTemplate;
    private final JwtProvider jwtProvider;
    private final MailSender mailSender;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Value("${hostname}")
    private String hostname;

    @Value("${recaptcha.secret}")
    private String secret;

    @Value("${recaptcha.url}")
    private String captchaUrl;

    public Map<String, String> login(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            User user = userRepository.findByEmail(email);
            String userRole = user.getRoles().iterator().next().name();
            String token = jwtProvider.createToken(email, userRole);
            Map<String, String> response = new HashMap<>();
            response.put("email", email);
            response.put("token", token);
            response.put("userRole", userRole);
            return response;
        } catch (AuthenticationException e) {
            throw new BadRequestException(ExceptionCode.UNSUCCESSFUL_LOGIN);
        }
    }

    public String registerUser(User user, String captcha, String password2) {
        String url = String.format(captchaUrl, secret, captcha);
        restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponse.class);

        if (user.getPassword() != null && !user.getPassword().equals(password2)) {
            throw new PasswordException("Passwords do not match.");
        }
        User userFromDb = userRepository.findByEmail(user.getEmail());

        if (userFromDb != null) {
            throw new EmailException("Email is already used.");
        }
        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        user.setProvider(AuthProvider.LOCAL);
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        String subject = "Activation code";
        String template = "registration-template";
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("firstName", user.getFirstName());
        attributes.put("registrationUrl", "http://" + hostname + "/api/v1/registration/activate/" + user.getActivationCode());
        mailSender.sendMessageHtml(user.getEmail(), subject, template, attributes);
        return "User successfully registered.";
    }

    public User registerOauth2User(String provider, OAuth2UserInfo oAuth2UserInfo) {
        User user = new User();
        user.setEmail(oAuth2UserInfo.getEmail());
        user.setFirstName(oAuth2UserInfo.getFirstName());
        user.setLastName(oAuth2UserInfo.getLastName());
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setProvider(AuthProvider.valueOf(provider.toUpperCase()));
        return userRepository.save(user);
    }

    public User updateOauth2User(User user, String provider, OAuth2UserInfo oAuth2UserInfo) {
        user.setFirstName(oAuth2UserInfo.getFirstName());
        user.setLastName(oAuth2UserInfo.getLastName());
        user.setProvider(AuthProvider.valueOf(provider.toUpperCase()));
        return userRepository.save(user);
    }

    public User findByPasswordResetCode(String code) {
        User user = userRepository.findByPasswordResetCode(code);

        if (user == null) {
            throw new BadRequestException(ExceptionCode.UNSUCCESSFUL_LOGIN);
        }
        return user;
    }

    public String sendPasswordResetCode(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new BadRequestException(ExceptionCode.UNSUCCESSFUL_LOGIN);
        }
        user.setPasswordResetCode(UUID.randomUUID().toString());
        userRepository.save(user);
        String subject = "Password reset";
        String template = "password-reset-template";
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("firstName", user.getFirstName());
        attributes.put("resetUrl", "http://" + hostname + "/reset/" + user.getPasswordResetCode());
        mailSender.sendMessageHtml(user.getEmail(), subject, template, attributes);
        return "Reset password code is send to your E-mail";
    }

    public String passwordReset(String email, String password, String password2) {
        if (ObjectUtils.isEmpty(password2)) {
            throw new PasswordConfirmationException("Password confirmation cannot be empty.");
        }
        if (password != null && !password.equals(password2)) {
            throw new PasswordException("Passwords do not match.");
        }
        User user = userRepository.findByEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setPasswordResetCode(null);
        userRepository.update(user);
        return "Password successfully changed!";
    }

    public String activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null) {
            throw new BadRequestException(ExceptionCode.ACTIVATION_CODE_ERROR);
        }
        user.setActivationCode(null);
        user.setActive(true);
        userRepository.update(user);
        return "User successfully activated.";
    }
}
