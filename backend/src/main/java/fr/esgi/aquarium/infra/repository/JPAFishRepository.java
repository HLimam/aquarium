package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.infra.repository.entity.FishEntity;
import fr.esgi.aquarium.infra.repository.entity.SpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JPAFishRepository extends JpaRepository<FishEntity,Long> {
    Optional<FishEntity> findByName(String name);
}
