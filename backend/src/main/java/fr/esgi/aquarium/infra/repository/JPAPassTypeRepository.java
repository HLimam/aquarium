package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.infra.repository.entity.PassTypeEntity;
import fr.esgi.aquarium.infra.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JPAPassTypeRepository extends JpaRepository<PassTypeEntity,Long> {
    Optional<PassTypeEntity> findByName(String name);
}
