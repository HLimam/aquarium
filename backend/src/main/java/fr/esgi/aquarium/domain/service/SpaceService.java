package fr.esgi.aquarium.domain.service;

import fr.esgi.aquarium.domain.model.Space;
import fr.esgi.aquarium.domain.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SpaceService {
    private final SpaceRepository SpaceRepository;

    public Space findById(Long spaceId){
        return SpaceRepository.findById(spaceId);
    }

    public void deleteById(Long spaceId){
        SpaceRepository.deleteById(spaceId);
    }

    public Space findByName(String name){
        return SpaceRepository.findByName(name);
    }

    public List<Space> findAll(){
        return SpaceRepository.findAll();
    }

    public Space save(Space Space){
        return SpaceRepository.save(Space);
    }

    public Space update(Space Space){
        return SpaceRepository.update(Space);
    }

}
