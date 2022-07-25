package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.exception.AquariumException;
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
        var pass = passRepository.findById(typeId);
        return pass.isPresent() ? mapper.toModel(pass.get()) : null;
    }

    @Override
    public void deleteById(Long typeId) {
        passRepository.deleteById(typeId);
    }

    @Override
    public List<Pass> findByUser(User user) {
        var passList = passRepository.findByUser(user);
        return passList.stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<Pass> findAll() {
        return passRepository.findAll().stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Pass save(Pass pass) {
        return mapper.toModel(passRepository.saveAndFlush(mapper.toEntity(pass)));
    }

    @Override
    public Pass update(Pass pass) {
        if (passRepository.findById(pass.getId()).isEmpty()) {
            throw new AquariumException(ExceptionCode.MODIFICATION_IMPOSSIBLE);
        }
        return mapper.toModel(passRepository.saveAndFlush(mapper.toEntity(pass)));
    }
}
