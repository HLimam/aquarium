package fr.esgi.aquarium.infra.web.service;

import fr.esgi.aquarium.domain.AuthProvider;
import fr.esgi.aquarium.domain.Role;
import fr.esgi.aquarium.domain.User;
import fr.esgi.aquarium.domain.UserRepository;
import fr.esgi.aquarium.infra.email.MailSender;
import fr.esgi.aquarium.infra.security.JwtProvider;
import fr.esgi.aquarium.infra.security.oauth2.*;
import fr.esgi.aquarium.infra.service.AuthenticationService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static fr.esgi.aquarium.util.TestConstants.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationServiceTest {

    @Autowired
    private AuthenticationService authenticationService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtProvider jwtProvider;

    @MockBean
    private MailSender mailSender;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Value("${hostname}")
    private String hostname;

    @Test
    public void findByPasswordResetCode() {
        User user = new User();
        user.setPasswordResetCode(USER_PASSWORD_RESET_CODE);
        when(userRepository.findByPasswordResetCode(USER_PASSWORD_RESET_CODE)).thenReturn(user);
        authenticationService.findByPasswordResetCode(USER_PASSWORD_RESET_CODE);

        assertEquals(USER_PASSWORD_RESET_CODE, user.getPasswordResetCode());
        verify(userRepository, times(1)).findByPasswordResetCode(USER_PASSWORD_RESET_CODE);
    }

    @Test
    public void login() {
        User user = new User();
        user.setId(123L);
        user.setEmail(USER_EMAIL);
        user.setPassword(USER_PASSWORD);
        user.setActive(true);
        user.setFirstName(FIRST_NAME);
        user.setRoles(Collections.singleton(Role.USER));

        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(user);
        assertEquals(Long.valueOf(123L), user.getId());
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        authenticationService.login(USER_EMAIL, USER_PASSWORD);
        verify(userRepository, times(1)).findByEmail(user.getEmail());
        verify(jwtProvider, times(1)).createToken(user.getEmail(), user.getRoles().iterator().next().name());
    }

    @Test
    public void registerUser() {
        User user = new User();
        user.setFirstName(FIRST_NAME);
        user.setEmail(USER_EMAIL);
        String userCreated = authenticationService.registerUser(user, "", USER_PASSWORD);
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("firstName", FIRST_NAME);
        attributes.put("registrationUrl", "http://" + hostname + "/api/v1/registration/activate/" + user.getActivationCode());

        assertNotNull(userCreated);
        assertNotNull(user.getActivationCode());
        assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));
        verify(userRepository, times(1)).save(user);
        verify(mailSender, times(1))
                .sendMessageHtml(
                        (user.getEmail()),
                        ("Activation code"),
                        ("registration-template"),
                        (attributes));
    }

    @Test
    public void registerGoogleOauthUser() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("sub", 123456);
        attributes.put("given_name", FIRST_NAME);
        attributes.put("family_name", LAST_NAME);
        attributes.put("email", USER_EMAIL);
        GoogleOAuth2UserInfo userInfo = new GoogleOAuth2UserInfo(attributes);
        OAuth2UserInfo google = OAuth2UserFactory.getOAuth2UserInfo("google", attributes);

        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setProvider(AuthProvider.GOOGLE);

        when(userRepository.save(user)).thenReturn(user);
        authenticationService.registerOauth2User("google", userInfo);
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertEquals(LAST_NAME, user.getLastName());
        assertEquals(google.getAttributes(), userInfo.getAttributes());
        assertNull(user.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void registerFacebookOauthUser() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("id", 123456);
        attributes.put("first_name", FIRST_NAME);
        attributes.put("last_name", LAST_NAME);
        attributes.put("email", USER_EMAIL);
        FacebookOAuth2UserInfo userInfo = new FacebookOAuth2UserInfo(attributes);
        OAuth2UserInfo facebook = OAuth2UserFactory.getOAuth2UserInfo("facebook", attributes);

        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setProvider(AuthProvider.FACEBOOK);

        when(userRepository.save(user)).thenReturn(user);
        authenticationService.registerOauth2User("facebook", userInfo);
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertEquals(LAST_NAME, user.getLastName());
        assertEquals(facebook.getAttributes(), userInfo.getAttributes());
        assertNull(user.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void registerGithubOauthUser() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("id", 123456);
        attributes.put("name", FIRST_NAME);
        attributes.put("email", USER_EMAIL);
        GithubOAuth2UserInfo userInfo = new GithubOAuth2UserInfo(attributes);
        OAuth2UserInfo github = OAuth2UserFactory.getOAuth2UserInfo("github", attributes);

        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName("");
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setProvider(AuthProvider.GITHUB);

        when(userRepository.save(user)).thenReturn(user);
        authenticationService.registerOauth2User("github", userInfo);
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertEquals(github.getAttributes(), userInfo.getAttributes());
        assertNull(user.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void updateOauthUser() {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("sub", 123456);
        attributes.put("given_name", FIRST_NAME);
        attributes.put("family_name", LAST_NAME);
        attributes.put("email", USER_EMAIL);
        GoogleOAuth2UserInfo userInfo = new GoogleOAuth2UserInfo(attributes);

        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setProvider(AuthProvider.GOOGLE);

        when(userRepository.save(user)).thenReturn(user);
        authenticationService.updateOauth2User(user, "google", userInfo);
        assertEquals(USER_EMAIL, user.getEmail());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertEquals(LAST_NAME, user.getLastName());
        assertEquals(AuthProvider.GOOGLE, user.getProvider());
        assertNull(user.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void sendPasswordResetCode() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setPasswordResetCode(USER_PASSWORD_RESET_CODE);

        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(user);
        authenticationService.sendPasswordResetCode(USER_EMAIL);
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("firstName", null);
        attributes.put("resetUrl", "http://" + hostname + "/reset/" + user.getPasswordResetCode());

        assertEquals(USER_EMAIL, user.getEmail());
        assertNotNull(user.getPasswordResetCode());
        verify(userRepository, times(1)).save(user);
        verify(userRepository, times(1)).findByEmail(user.getEmail());
        verify(mailSender, times(1))
                .sendMessageHtml(
                        (user.getEmail()),
                        ("Password reset"),
                        ("password-reset-template"),
                        (attributes));
    }

    @Test
    public void passwordReset() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setPassword(USER_PASSWORD);

        when(userRepository.findByEmail(USER_EMAIL)).thenReturn(user);
        when(passwordEncoder.encode(USER_PASSWORD)).thenReturn(user.getPassword());
        when(userRepository.save(user)).thenReturn(user);
        authenticationService.passwordReset(user.getEmail(), user.getPassword(), user.getPassword());
        assertEquals(USER_EMAIL, user.getEmail());
        assertNotNull(user.getPassword());
        verify(userRepository, times(1)).findByEmail(user.getEmail());
        verify(passwordEncoder, times(1)).encode(user.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void activateUser() {
        User user = new User();
        user.setActivationCode(USER_ACTIVATION_CODE);

        when(userRepository.findByActivationCode(USER_ACTIVATION_CODE)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        String activated = authenticationService.activateUser(user.getActivationCode());
        assertNotNull(activated);
        assertNull(user.getActivationCode());
        verify(userRepository, times(1)).save(user);
    }
}
