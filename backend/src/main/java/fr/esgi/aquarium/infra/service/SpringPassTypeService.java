package fr.esgi.aquarium.infra.service;


import fr.esgi.aquarium.domain.repository.PassTypeRepository;
import fr.esgi.aquarium.domain.repository.UserRepository;
import fr.esgi.aquarium.domain.service.PassTypeService;
import fr.esgi.aquarium.domain.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class SpringPassTypeService extends PassTypeService {
    public SpringPassTypeService(PassTypeRepository passTypeRepository) {
        super(passTypeRepository);
    }
}
