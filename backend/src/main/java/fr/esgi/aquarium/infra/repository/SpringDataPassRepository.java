package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.exception.AquariumException;
import fr.esgi.aquarium.domain.exception.EntityNotFoundException;
import fr.esgi.aquarium.domain.exception.ExceptionCode;
import fr.esgi.aquarium.domain.model.Pass;
import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.domain.repository.PassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Primary
public class SpringDataPassRepository implements PassRepository {

    private final JPAPassRepository passRepository;
    private final PassMapper mapper;

    @Override
    public Pass findById(Long typeId) {
        var Pass = passRepository.findById(typeId);
        if(Pass.isEmpty()){
            throw new EntityNotFoundException();
        }
        return mapper.toModel(Pass.get());
    }

    @Override
    public void deleteById(Long typeId) {
        passRepository.deleteById(typeId);
    }

    @Override
    public Pass findByUser(User user) {
        var Pass = passRepository.findByUser(user);
        if(Pass.isEmpty()){
            throw new EntityNotFoundException();
        }
        return mapper.toModel(Pass.get());
    }

    @Override
    public List<Pass> findAll() {
        return passRepository.findAll().stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Pass save(Pass Pass) {
        return mapper.toModel(passRepository.saveAndFlush(mapper.toEntity(Pass)));
    }

    @Override
    public Pass update(Pass Pass) {
        if(passRepository.findById(Pass.getId()).isEmpty()){
            throw new AquariumException(ExceptionCode.MODIFICATION_IMPOSSIBLE);
        }
        return mapper.toModel(passRepository.saveAndFlush(mapper.toEntity(Pass)));
    }
}
