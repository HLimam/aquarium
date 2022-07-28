package fr.esgi.aquarium.domain.repository;

import fr.esgi.aquarium.domain.model.Maintenance;

import java.util.List;

public interface MaintenanceRepository {

    List<Maintenance> findAllMaintenances();

    Maintenance findById(Long maintenanceId);

    List<Maintenance> findByManagerId(Long managerId);

    List<Maintenance> findBySpaceId(Long spaceId);

    Maintenance updateMaintenance(Maintenance maintenance);

    void deleteMaintenanceById(Long maintenanceId);

    Maintenance saveMaintenance(Maintenance maintenance);
}
