package fr.esgi.aquarium.infra.service;


import fr.esgi.aquarium.domain.repository.FishRepository;
import fr.esgi.aquarium.domain.repository.SpaceRepository;
import fr.esgi.aquarium.domain.service.FishService;
import fr.esgi.aquarium.domain.service.SpaceService;
import org.springframework.stereotype.Service;

@Service
public class SpringFishService extends FishService {
    public SpringFishService(FishRepository fishRepository) {
        super(fishRepository);
    }
}
