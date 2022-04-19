package fr.esgi.aquarium.infra.web.api;

import fr.esgi.aquarium.infra.security.UserPrincipal;
import fr.esgi.aquarium.infra.web.exception.InputFieldException;
import fr.esgi.aquarium.infra.web.mapper.UserApiMapper;
import fr.esgi.aquarium.infra.web.request.UserRequest;
import fr.esgi.aquarium.infra.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserApiMapper userApiMapper;

    @GetMapping("/info")
    public ResponseEntity<UserResponse> getUserInfo(@AuthenticationPrincipal UserPrincipal user) {
        return ResponseEntity.ok(userApiMapper.findUserByEmail(user.getEmail()));
    }

    @PutMapping("/edit")
    public ResponseEntity<UserResponse> updateUserInfo(@AuthenticationPrincipal UserPrincipal user,
                                                       @Valid @RequestBody UserRequest request,
                                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(userApiMapper.updateProfile(user.getEmail(), request));
        }
    }

}
