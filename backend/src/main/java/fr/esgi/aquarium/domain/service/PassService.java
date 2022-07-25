package fr.esgi.aquarium.domain.service;

import fr.esgi.aquarium.domain.model.Pass;
import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.domain.repository.PassRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class PassService {
    private final PassRepository passRepository;

    public Pass findById(Long psssTypeId) {
        return passRepository.findById(psssTypeId);
    }

    public void deleteById(Long psssTypeId) {
        passRepository.deleteById(psssTypeId);
    }

    public List<Pass> findByUser(User user) {
        return passRepository.findByUser(user);
    }

    public List<Pass> findAll() {
        return passRepository.findAll();
    }

    public Pass save(Pass pass) {
        pass.setIsAvailable(Boolean.TRUE);
        switch (pass.getType()) {
            case DAILY:
                pass.setDateHourPeremption(pass.getDateHourPurchase().plusDays(1));
                break;
            case WEEKLY:
                pass.setDateHourPeremption(pass.getDateHourPurchase().plusDays(7));
                break;
            case MONTHLY:
                pass.setDateHourPeremption(pass.getDateHourPurchase().plusMonths(1));
                break;
            case ANNUALLY:
                pass.setDateHourPeremption(pass.getDateHourPurchase().plusYears(1));
                break;
        }
        return passRepository.save(pass);
    }

    public Pass update(Pass pass) {
        return passRepository.update(pass);
    }

    public Pass updateAvailability(Long psssTypeId) {
        var pass = passRepository.findById(psssTypeId);
        var now = LocalDateTime.now();
        pass.setIsAvailable(pass.getIsAvailable() && now.isBefore(pass.getDateHourPeremption()));
        passRepository.update(pass);
        return pass;
    }

}
