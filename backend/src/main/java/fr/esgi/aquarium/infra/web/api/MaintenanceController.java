package fr.esgi.aquarium.infra.web.api;

import fr.esgi.aquarium.infra.service.MaintenanceService;
import fr.esgi.aquarium.infra.web.mapper.MaintenanceApiMapper;
import fr.esgi.aquarium.infra.web.request.MaintenanceRequest;
import fr.esgi.aquarium.infra.web.response.MaintenanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @GetMapping
    public ResponseEntity<List<MaintenanceResponse>> getAllMaintenances() {
        var Maintenances = maintenanceService.findAllMaintenances().stream().map(MaintenanceApiMapper::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(Maintenances);
    }

    @GetMapping("/{maintenanceId}")
    public ResponseEntity<MaintenanceResponse> getMaintenanceById(@PathVariable("maintenanceId") Long maintenanceId) {
        var maintenance = MaintenanceApiMapper.convertToResponseDto(maintenanceService.findMaintenanceById(maintenanceId));
        return ResponseEntity.ok(maintenance);
    }

    @GetMapping("/manager/{managerId}")
    public ResponseEntity<MaintenanceResponse> getMaintenanceByManagerId(@PathVariable("managerId") Long managerId) {
        var maintenance = MaintenanceApiMapper.convertToResponseDto(maintenanceService.findMaintenanceByManagerId(managerId));
        return ResponseEntity.ok(maintenance);
    }

    @GetMapping("/space/{spaceId}")
    public ResponseEntity<MaintenanceResponse> getMaintenanceBySpaceId(@PathVariable("spaceId") Long spaceId) {
        var maintenance = MaintenanceApiMapper.convertToResponseDto(maintenanceService.findMaintenanceBySpaceId(spaceId));
        return ResponseEntity.ok(maintenance);
    }

    @PutMapping("/close/{maintenanceId}")
    public ResponseEntity<MaintenanceResponse> closeMaintenanceById(@PathVariable("maintenanceId") Long maintenanceId) {
        var maintenance = MaintenanceApiMapper.convertToResponseDto(maintenanceService.closeMaintenanceById(maintenanceId));
        return ResponseEntity.ok(maintenance);
    }

    @DeleteMapping("/{maintenanceId}")
    public ResponseEntity deleteMaintenanceById(@PathVariable("maintenanceId") Long maintenanceId) {
        maintenanceService.deleteMaintenanceById(maintenanceId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> createMaintenance(@RequestBody MaintenanceRequest request) {
        var maintenance = maintenanceService.saveMaintenance(MaintenanceApiMapper.convertToModel(request));
        URI location = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() + "/" + maintenance.getMaintenanceId());
        return ResponseEntity.created(location).build();
    }

}
