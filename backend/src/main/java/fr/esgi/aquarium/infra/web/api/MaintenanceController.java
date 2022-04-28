package fr.esgi.aquarium.infra.web.api;

import fr.esgi.aquarium.infra.web.mapper.MaintenanceApiMapper;
import fr.esgi.aquarium.infra.web.response.MaintenanceResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/maintenance")
public class MaintenanceController {

    private final MaintenanceApiMapper maintenanceMapper;

    @GetMapping("/")
    public ResponseEntity<List<MaintenanceResponse>> getAllMaintenances() {
        return ResponseEntity.ok(maintenanceMapper.findAllMaintenances());
    }

    /*@PutMapping("/edit")
    public ResponseEntity<UserResponse> updateUserInfo(@AuthenticationPrincipal UserPrincipal user,
                                                       @Valid @RequestBody UserRequest request,
                                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(maintenanceMapper.updateProfile(user.getEmail(), request));
        }
    }*/

}
