package fr.esgi.aquarium.infra.service;


import fr.esgi.aquarium.domain.repository.MaintenanceRepository;
import fr.esgi.aquarium.domain.service.MaintenanceService;
import org.springframework.stereotype.Service;

@Service
public class SpringMaintenanceService extends MaintenanceService {
    public SpringMaintenanceService(MaintenanceRepository maintenanceRepository) {
        super(maintenanceRepository);
    }
}
