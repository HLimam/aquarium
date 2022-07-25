package fr.esgi.aquarium.infra.service;


import fr.esgi.aquarium.domain.repository.PassRepository;
import fr.esgi.aquarium.domain.service.PassService;
import org.springframework.stereotype.Service;

@Service
public class SpringPassService extends PassService {
    public SpringPassService(PassRepository passRepository) {
        super(passRepository);
    }

}
