package fr.esgi.aquarium.domain.service;

import fr.esgi.aquarium.domain.model.Fish;
import fr.esgi.aquarium.domain.model.Space;
import fr.esgi.aquarium.domain.repository.FishRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FishService {
    private final FishRepository fishRepository;

    public Fish findById(Long fishId){
        return fishRepository.findById(fishId);
    }

    public void deleteById(Long fishId){
        fishRepository.deleteById(fishId);
    }

    public Fish findByName(String name){
        return fishRepository.findByName(name);
    }

    public List<Fish> findAll(){
        return fishRepository.findAll();
    }

    public Fish save(Fish fish){
        return fishRepository.save(fish);
    }

    public Fish update(Fish fish){
        return fishRepository.update(fish);
    }

}
