package fr.esgi.aquarium.domain.service;

import fr.esgi.aquarium.domain.model.PassType;
import fr.esgi.aquarium.domain.repository.PassTypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PassTypeService {
    private final PassTypeRepository passTypeRepository;

    public PassType findById(Long psssTypeId){
        return passTypeRepository.findById(psssTypeId);
    }

    public void deleteById(Long psssTypeId){
        passTypeRepository.deleteById(psssTypeId);
    }

    public PassType findByName(String name){
        return passTypeRepository.findByName(name);
    }

    public List<PassType> findAll(){
        return passTypeRepository.findAll();
    }

    public PassType save(PassType passType){
        return passTypeRepository.save(passType);
    }

    public PassType update(PassType passType){
        return passTypeRepository.update(passType);
    }

    public PassType updateAvailability(Long psssTypeId, Boolean availability){
        var passType = passTypeRepository.findById(psssTypeId);
        passType.setIsAvailable(availability);
        return passTypeRepository.update(passType);
    }

}
