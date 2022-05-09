package fr.esgi.aquarium.infra.web.api;

import fr.esgi.aquarium.infra.service.AuthenticationService;
import fr.esgi.aquarium.infra.web.exception.InputFieldException;
import fr.esgi.aquarium.infra.web.mapper.UserApiMapper;
import fr.esgi.aquarium.infra.web.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationRequest user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        return ResponseEntity.ok(authenticationService.registerUser(UserApiMapper.convertToModel(user), user.getCaptcha(), user.getPassword2()));
    }

    @GetMapping("/activate/{code}")
    public ResponseEntity<String> activateEmailCode(@PathVariable String code) {
        return ResponseEntity.ok(authenticationService.activateUser(code));
    }
}
