package fr.esgi.aquarium.infra.web.api;

import fr.esgi.aquarium.domain.service.UserService;
import fr.esgi.aquarium.infra.security.UserPrincipal;
import fr.esgi.aquarium.infra.service.SpringUserService;
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

    private final SpringUserService userService;

    @GetMapping("/info")
    public ResponseEntity<UserResponse> getUserInfo(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        var user = UserApiMapper.convertToResponseDto(userService.findUserByEmail(userPrincipal.getEmail()));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/edit")
    public ResponseEntity<UserResponse> updateUserInfo(@AuthenticationPrincipal UserPrincipal userPrincipal,
                                                       @Valid @RequestBody UserRequest request,
                                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            var user = UserApiMapper.convertToResponseDto(userService.updateProfile(userPrincipal.getEmail(), UserApiMapper.convertToModel(request)));
            return ResponseEntity.ok(user);
        }
    }

}
