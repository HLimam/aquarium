package fr.esgi.aquarium.domain.repository;

import fr.esgi.aquarium.domain.model.Pass;
import fr.esgi.aquarium.domain.model.User;

import java.util.List;

public interface PassRepository {
    Pass findById(Long typeId);

    void deleteById(Long typeId);

    List<Pass> findByUser(User user);

    List<Pass> findAll();

    Pass save(Pass Pass);

    Pass update(Pass Pass);
}
