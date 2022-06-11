package fr.esgi.aquarium.infra.service;


import fr.esgi.aquarium.domain.repository.PassRepository;
import fr.esgi.aquarium.domain.repository.UserRepository;
import fr.esgi.aquarium.domain.service.PassService;
import fr.esgi.aquarium.domain.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class SpringPassService extends PassService {
    private static final String FILES_PATH = "src/resources/fileToCreate/";

    public SpringPassService(PassRepository passRepository,UserService userService) {
        super(passRepository,userService);
    }


}
