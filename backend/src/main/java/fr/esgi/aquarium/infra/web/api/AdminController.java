package fr.esgi.aquarium.infra.web.api;

import fr.esgi.aquarium.domain.service.UserService;
import fr.esgi.aquarium.infra.web.mapper.UserApiMapper;
import fr.esgi.aquarium.infra.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long userId) {
        var user = UserApiMapper.convertToResponseDto(userService.findUserById(userId));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        var users = userService.findAllUsers()
                .stream()
                .map(UserApiMapper::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }


}
