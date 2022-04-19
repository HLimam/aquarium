package fr.esgi.aquarium.domain;

import java.util.List;

public interface UserRepository {
   User findById(Long userId);

    User findByEmail(String email);

    List<User> findAllByOrderByIdAsc();

    User save(User userFromDb);

    User findByPasswordResetCode(String code);

    User findByActivationCode(String code);
}
