package fr.esgi.aquarium.infra.web.mapper;


import fr.esgi.aquarium.infra.service.AuthenticationService;
import fr.esgi.aquarium.infra.web.request.AuthenticationRequest;
import fr.esgi.aquarium.infra.web.request.PasswordResetRequest;
import fr.esgi.aquarium.infra.web.request.RegistrationRequest;
import fr.esgi.aquarium.infra.web.response.AuthenticationResponse;
import fr.esgi.aquarium.infra.web.response.UserResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuthenticationMapper {

    private final AuthenticationService authenticationService;
    private final UserApiMapper userApiMapper;

    public AuthenticationMapper(@Lazy AuthenticationService authenticationService, UserApiMapper userApiMapper) {
        this.authenticationService = authenticationService;
        this.userApiMapper = userApiMapper;
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        Map<String, String> credentials = authenticationService.login(request.getEmail(), request.getPassword());
        AuthenticationResponse response = new AuthenticationResponse();
        response.setEmail(credentials.get("email"));
        response.setToken(credentials.get("token"));
        response.setUserRole(credentials.get("userRole"));
        return response;
    }

    public UserResponse findByPasswordResetCode(String code) {
        return userApiMapper.convertToResponseDto(authenticationService.findByPasswordResetCode(code));
    }

    public String registerUser(String captcha, RegistrationRequest registrationRequest) {
        return authenticationService.registerUser(userApiMapper.convertToEntity(registrationRequest), captcha, registrationRequest.getPassword2());
    }

    public String activateUser(String code) {
        return authenticationService.activateUser(code);
    }

    public String sendPasswordResetCode(String email) {
        return authenticationService.sendPasswordResetCode(email);
    }

    public String passwordReset(String email, PasswordResetRequest passwordReset) {
        return authenticationService.passwordReset(email, passwordReset.getPassword(), passwordReset.getPassword2());
    }
}
