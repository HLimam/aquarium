package fr.esgi.aquarium.infra.web.api;


import fr.esgi.aquarium.infra.security.UserPrincipal;
import fr.esgi.aquarium.infra.service.AuthenticationService;
import fr.esgi.aquarium.infra.web.exception.InputFieldException;
import fr.esgi.aquarium.infra.web.mapper.UserApiMapper;
import fr.esgi.aquarium.infra.web.request.AuthenticationRequest;
import fr.esgi.aquarium.infra.web.request.PasswordResetRequest;
import fr.esgi.aquarium.infra.web.response.AuthenticationResponse;
import fr.esgi.aquarium.infra.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        Map<String, String> credentials = authenticationService.login(request.getEmail(), request.getPassword());
        AuthenticationResponse response = AuthenticationResponse.builder()
                .email(credentials.get("email"))
                .token(credentials.get("token"))
                .userRole(credentials.get("userRole"))
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/forgot")
    public ResponseEntity<String> forgotPassword(@RequestBody PasswordResetRequest passwordReset) {
        return ResponseEntity.ok(authenticationService.sendPasswordResetCode(passwordReset.getEmail()));
    }

    @GetMapping("/reset/{code}")
    public ResponseEntity<UserResponse> getPasswordResetCode(@PathVariable String code) {
        var user = UserApiMapper.convertToResponseDto(authenticationService.findByPasswordResetCode(code));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> passwordReset(@RequestBody PasswordResetRequest passwordReset) {
        return ResponseEntity.ok(authenticationService.passwordReset(passwordReset.getEmail(),passwordReset.getPassword(),passwordReset.getPassword2()));
    }

    @PutMapping("/edit/password")
    public ResponseEntity<String> updateUserPassword(@AuthenticationPrincipal UserPrincipal userPrincipal,
                                                     @Valid @RequestBody PasswordResetRequest passwordReset,
                                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(authenticationService.passwordReset(userPrincipal.getEmail(), passwordReset.getPassword(), passwordReset.getPassword2()));
        }
    }
}
