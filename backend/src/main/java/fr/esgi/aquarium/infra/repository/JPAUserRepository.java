package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.infra.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAUserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByOrderByIdAsc();

    UserEntity findByEmail(String email);

    UserEntity findByPasswordResetCode(String code);

    UserEntity findByActivationCode(String code);
}
