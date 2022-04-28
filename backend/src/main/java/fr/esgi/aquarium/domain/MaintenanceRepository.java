package fr.esgi.aquarium.domain;

import java.util.List;

public interface MaintenanceRepository {

    List<Maintenance> findAllMaintenances();

//   User findById(Long userId);
//
//    User findByEmail(String email);

//    User save(User userFromDb);
//
//    User findByPasswordResetCode(String code);
//
//    User findByActivationCode(String code);
}
