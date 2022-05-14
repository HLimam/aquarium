package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.exception.AquariumException;
import fr.esgi.aquarium.domain.exception.EntityNotFoundException;
import fr.esgi.aquarium.domain.exception.ExceptionCode;
import fr.esgi.aquarium.domain.model.PassType;
import fr.esgi.aquarium.domain.repository.PassTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Primary
public class SpringDataPassTypeRepository implements PassTypeRepository {

    private final JPAPassTypeRepository passTypeRepository;
    private final PassTypeMapper mapper;

    @Override
    public PassType findById(Long typeId) {
        var passType = passTypeRepository.findById(typeId);
        if(passType.isEmpty()){
            throw new EntityNotFoundException();
        }
        return mapper.toModel(passType.get());
    }

    @Override
    public void deleteById(Long typeId) {
        passTypeRepository.deleteById(typeId);
    }

    @Override
    public PassType findByName(String name) {
        var passType = passTypeRepository.findByName(name);
        if(passType.isEmpty()){
            throw new EntityNotFoundException();
        }
        return mapper.toModel(passType.get());
    }

    @Override
    public List<PassType> findAll() {
        return passTypeRepository.findAll().stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public PassType save(PassType passType) {
        if(passTypeRepository.findByName(passType.getName()).isPresent()){
            throw new AquariumException(ExceptionCode.ENTITY_CREATION_ERROR);
        }
        return mapper.toModel(passTypeRepository.saveAndFlush(mapper.toEntity(passType)));
    }

    @Override
    public PassType update(PassType passType) {
        if(passTypeRepository.findById(passType.getId()).isEmpty()){
            throw new AquariumException(ExceptionCode.MODIFICATION_IMPOSSIBLE);
        }
        return mapper.toModel(passTypeRepository.saveAndFlush(mapper.toEntity(passType)));
    }
}
