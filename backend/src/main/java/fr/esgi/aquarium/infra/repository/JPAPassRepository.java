package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.infra.repository.entity.PassEntity;
import fr.esgi.aquarium.infra.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JPAPassRepository extends JpaRepository<PassEntity,Long> {
    List<PassEntity> findByUser(User user);
}
