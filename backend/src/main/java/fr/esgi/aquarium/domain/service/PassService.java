package fr.esgi.aquarium.domain.service;

import fr.esgi.aquarium.domain.enumeration.PassType;
import fr.esgi.aquarium.domain.model.Pass;
import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.domain.repository.PassRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class PassService {
    private final PassRepository passRepository;
    private final UserService userService;

    public Pass findById(Long psssTypeId){
        return passRepository.findById(psssTypeId);
    }

    public void deleteById(Long psssTypeId){
        passRepository.deleteById(psssTypeId);
    }

    public List<Pass> findUserByEmail(String email){
        var user = userService.findUserByEmail(email);
        return passRepository.findByUser(user);
    }

    public List<Pass> findAll(){
        return passRepository.findAll();
    }

    public Pass save(Pass pass){
        var now = LocalDateTime.now();
        pass.setDateHourPurchase(now);
        switch (pass.getType()){
            case DAILY: pass.setDateHourPeremption(now.plusDays(1)); break;
            case WEEKLY: pass.setDateHourPeremption(now.plusDays(7)); break;
            case MONTHLY: pass.setDateHourPeremption(now.plusMonths(1)); break;
            case ANNUALLY: pass.setDateHourPeremption(now.plusYears(1)); break;
        }
        return passRepository.save(pass);
    }

    public Pass update(Pass pass){
        return passRepository.update(pass);
    }

    public Pass checkAvailability(Long psssTypeId){
        var pass = passRepository.findById(psssTypeId);
        var now = LocalDateTime.now();
        pass.setIsAvailable(pass.getIsAvailable() && now.isBefore(pass.getDateHourPeremption()));
        passRepository.update(pass);
        return pass;
    }

}
