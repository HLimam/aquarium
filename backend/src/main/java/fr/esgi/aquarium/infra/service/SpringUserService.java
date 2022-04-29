package fr.esgi.aquarium.infra.service;


import fr.esgi.aquarium.domain.repository.UserRepository;
import fr.esgi.aquarium.domain.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class SpringUserService extends UserService {
    public SpringUserService(UserRepository userRepository) {
        super(userRepository);
    }
}
