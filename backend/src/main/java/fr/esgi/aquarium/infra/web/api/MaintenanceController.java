package fr.esgi.aquarium.infra.web.api;

import fr.esgi.aquarium.infra.web.mapper.MaintenanceApiMapper;
import fr.esgi.aquarium.infra.web.request.AuthenticationRequest;
import fr.esgi.aquarium.infra.web.request.MaintenanceRequest;
import fr.esgi.aquarium.infra.web.response.MaintenanceResponse;
import fr.esgi.aquarium.infra.web.response.UserResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/maintenance")
public class MaintenanceController {

    private final MaintenanceApiMapper maintenanceApiMapper;

    @GetMapping("/")
    public ResponseEntity<List<MaintenanceResponse>> getAllMaintenances() {
        return ResponseEntity.ok(maintenanceApiMapper.findAllMaintenances());
    }

    @GetMapping("/{maintenanceId}")
    public ResponseEntity<MaintenanceResponse> getMaintenanceById(@PathVariable("maintenanceId") Long maintenanceId) {
        return ResponseEntity.ok(maintenanceApiMapper.findMaintenanceById(maintenanceId));
    }

    @GetMapping("/manager/{managerId}")
    public ResponseEntity<MaintenanceResponse> getMaintenanceByManagerId(@PathVariable("managerId") Long managerId) {
        return ResponseEntity.ok(maintenanceApiMapper.findMaintenanceByManagerId(managerId));
    }

    @GetMapping("/space/{spaceId}")
    public ResponseEntity<MaintenanceResponse> getMaintenanceBySpaceId(@PathVariable("spaceId") Long spaceId) {
        return ResponseEntity.ok(maintenanceApiMapper.findMaintenanceBySpaceId(spaceId));
    }

    @PutMapping("/close/{maintenanceId}")
    public ResponseEntity<MaintenanceResponse> closeMaintenanceById(@PathVariable("maintenanceId") Long maintenanceId) {
        return ResponseEntity.ok(maintenanceApiMapper.closeMaintenanceById(maintenanceId));
    }

    @DeleteMapping("/delete/{maintenanceId}")
    public void deleteMaintenanceById(@PathVariable("maintenanceId") Long maintenanceId) {
        maintenanceApiMapper.deleteMaintenanceById(maintenanceId);
    }

    @PostMapping("/create}")
    public ResponseEntity<MaintenanceResponse> createMaintenance(@RequestBody MaintenanceRequest request) {
        return ResponseEntity.ok(maintenanceApiMapper.createMaintenance(request));
    }

}
