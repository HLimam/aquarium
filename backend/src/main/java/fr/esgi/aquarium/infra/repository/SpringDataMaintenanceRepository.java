package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.model.Maintenance;
import fr.esgi.aquarium.domain.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Primary
public class SpringDataMaintenanceRepository implements MaintenanceRepository {

    private final JPAMaintenanceRepository jpaMaintenanceRepository;
    private final MaintenanceMapper mapper;


    @Override
    public List<Maintenance> findAllMaintenances() {
        return jpaMaintenanceRepository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Maintenance findById(Long maintenanceId) {
        return jpaMaintenanceRepository.findById(maintenanceId).map(mapper::toModel).orElse(null);
    }

    @Override
    public List<Maintenance> findByManagerId(Long managerId) {
        return jpaMaintenanceRepository.findByManagerId(managerId).stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<Maintenance> findBySpaceId(Long spaceId) {
        return jpaMaintenanceRepository.findBySpaceId(spaceId).stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Maintenance updateMaintenance(Maintenance maintenance) {
        return mapper.toModel(jpaMaintenanceRepository.saveAndFlush(mapper.toEntity(maintenance)));
    }

    @Override
    public void deleteMaintenanceById(Long maintenanceId) {
        jpaMaintenanceRepository.deleteById(maintenanceId);
    }

    @Override
    public Maintenance saveMaintenance(Maintenance maintenance) {
        return mapper.toModel(jpaMaintenanceRepository.save(mapper.toEntity(maintenance)));
    }
}
