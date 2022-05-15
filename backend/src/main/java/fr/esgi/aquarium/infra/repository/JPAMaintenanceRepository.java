package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.infra.repository.entity.MaintenanceEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAMaintenanceRepository extends JpaRepository<MaintenanceEntity,Long> {
    List<MaintenanceEntity> findByManagerId(Long managerId);

    List<MaintenanceEntity> findBySpaceId(Long spaceId);
}
