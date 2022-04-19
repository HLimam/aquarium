package fr.esgi.aquarium.infra.service;


import fr.esgi.aquarium.domain.UserRepository;
import fr.esgi.aquarium.domain.UserService;
import org.springframework.stereotype.Component;

@Component
public class SpringUserService extends UserService {
    public SpringUserService(UserRepository userRepository) {
        super(userRepository);
    }
}