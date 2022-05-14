package fr.esgi.aquarium.domain.repository;

import fr.esgi.aquarium.domain.model.PassType;
import fr.esgi.aquarium.domain.model.User;

import java.util.List;

public interface PassTypeRepository {
   PassType findById(Long typeId);

   void deleteById(Long typeId);

   PassType findByName(String name);

   List<PassType> findAll();

   PassType save(PassType passType);

   PassType update(PassType passType);
}
