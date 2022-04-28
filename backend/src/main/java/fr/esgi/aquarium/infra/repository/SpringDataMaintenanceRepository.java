package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.Maintenance;
import fr.esgi.aquarium.domain.MaintenanceRepository;
import fr.esgi.aquarium.infra.web.mapper.MaintenanceApiMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Primary
public class SpringDataMaintenanceRepository implements MaintenanceRepository {

    private final JPAMaintenanceRepository maintenanceRepository;
    private final MaintenanceMapper     mapper;


//    @Override
//    public User findById(Long userId) {
//        var user = maintenanceRepository.findById(userId);
//        if(user.isPresent()){
//            return mapper.toModel(user.get());
//        }else{
//            return null;
//        }
//    }
//
//    @Override
//    public User findByEmail(String email) {
//        return mapper.toModel(maintenanceRepository.findByEmail(email));
//    }

    @Override
    public List<Maintenance> findAllMaintenances() {
        return maintenanceRepository.findAll().stream()
                                    .map(mapper::toModel)
                                    .collect(Collectors.toList());
    }

    /*@Override
    public User save(User userFromDb) {
        return mapper.toModel(maintenanceRepository.saveAndFlush(mapper.toEntity(userFromDb)));
    }

    @Override
    public User findByPasswordResetCode(String code) {
        return mapper.toModel(maintenanceRepository.findByPasswordResetCode(code));
    }

    @Override
    public User findByActivationCode(String code) {
        return mapper.toModel(maintenanceRepository.findByActivationCode(code));
    }*/
}
