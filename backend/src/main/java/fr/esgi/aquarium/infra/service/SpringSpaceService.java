package fr.esgi.aquarium.infra.service;


import fr.esgi.aquarium.domain.repository.SpaceRepository;
import fr.esgi.aquarium.domain.service.SpaceService;
import org.springframework.stereotype.Service;

@Service
public class SpringSpaceService extends SpaceService {
    public SpringSpaceService(SpaceRepository SpaceRepository) {
        super(SpaceRepository);
    }
}
