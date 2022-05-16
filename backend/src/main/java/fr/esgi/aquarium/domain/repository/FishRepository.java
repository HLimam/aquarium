package fr.esgi.aquarium.domain.repository;

import fr.esgi.aquarium.domain.model.Fish;
import fr.esgi.aquarium.domain.model.Space;

import java.util.List;

public interface FishRepository {
   Fish findById(Long d);

   void deleteById(Long d);

   Fish findByName(String name);

   List<Fish> findAll();

   Fish save(Fish Space);

   Fish update(Fish Space);
}
