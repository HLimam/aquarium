package fr.esgi.aquarium.domain.repository;

import fr.esgi.aquarium.domain.model.Space;

import java.util.List;

public interface SpaceRepository {
    Space findById(Long d);

    void deleteById(Long d);

    Space findByName(String name);

    List<Space> findAll();

    Space save(Space Space);

    Space update(Space Space);
}
