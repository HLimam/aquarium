package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.model.Space;
import fr.esgi.aquarium.infra.repository.entity.PassEntity;
import fr.esgi.aquarium.infra.repository.entity.SpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPASpaceRepository extends JpaRepository<SpaceEntity,Long> {
    Optional<SpaceEntity> findByName(String name);
}
