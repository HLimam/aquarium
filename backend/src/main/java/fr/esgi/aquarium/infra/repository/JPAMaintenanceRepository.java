package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.infra.repository.model.MaintenanceEntity;
import fr.esgi.aquarium.infra.repository.model.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAMaintenanceRepository extends JpaRepository<MaintenanceEntity,Long> {
    MaintenanceEntity findByManagerId(Long managerId);

    MaintenanceEntity findBySpaceId(Long spaceId);
}
