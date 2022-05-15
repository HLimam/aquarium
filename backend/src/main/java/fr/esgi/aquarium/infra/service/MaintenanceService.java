package fr.esgi.aquarium.infra.service;

import fr.esgi.aquarium.domain.model.Maintenance;
import fr.esgi.aquarium.domain.repository.MaintenanceRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public List<Maintenance> findAllMaintenances() {
        return maintenanceRepository.findAllMaintenances();
    }

    public Maintenance findMaintenanceById(Long maintenanceId) {
        return maintenanceRepository.findById(maintenanceId);
    }

    public List<Maintenance> findMaintenanceByManagerId(Long managerId) {
        return maintenanceRepository.findByManagerId(managerId);
    }

    public List<Maintenance> findMaintenanceBySpaceId(Long spaceId) {
        return maintenanceRepository.findBySpaceId(spaceId);
    }

    public Maintenance closeMaintenanceById(Long maintenanceId) {
        Maintenance maintenance = maintenanceRepository.findById(maintenanceId);
        maintenance.setDateHourEnd(LocalDateTime.now());
        return maintenanceRepository.updateMaintenance(maintenance);
    }

    public void deleteMaintenanceById(Long maintenanceId) {
        maintenanceRepository.deleteMaintenanceById(maintenanceId);
    }

    public Maintenance saveMaintenance(Maintenance maintenance) {
        return maintenanceRepository.saveMaintenance(maintenance);
    }
}
