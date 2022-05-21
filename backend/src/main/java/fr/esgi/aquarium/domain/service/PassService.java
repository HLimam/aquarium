package fr.esgi.aquarium.domain.service;

import fr.esgi.aquarium.domain.model.Pass;
import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.domain.repository.PassRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PassService {
    private final PassRepository passRepository;

    public Pass findById(Long psssTypeId){
        return passRepository.findById(psssTypeId);
    }

    public void deleteById(Long psssTypeId){
        passRepository.deleteById(psssTypeId);
    }

    public Pass findByUserName(String userName){
        return null;
    }

    public List<Pass> findAll(){
        return passRepository.findAll();
    }

    public Pass save(Pass Pass){
        return passRepository.save(Pass);
    }

    public Pass update(Pass Pass){
        return passRepository.update(Pass);
    }

    public Pass updateAvailability(Long psssTypeId, Boolean availability){
        var Pass = passRepository.findById(psssTypeId);
        Pass.setIsAvailable(availability);
        return passRepository.update(Pass);
    }

}
