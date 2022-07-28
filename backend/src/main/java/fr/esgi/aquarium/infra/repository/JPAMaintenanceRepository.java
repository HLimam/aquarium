package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.infra.repository.entity.MaintenanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAMaintenanceRepository extends JpaRepository<MaintenanceEntity, Long> {
    List<MaintenanceEntity> findByManagerId(Long managerId);

    List<MaintenanceEntity> findBySpaceId(Long spaceId);
}
