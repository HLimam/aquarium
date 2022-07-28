package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.exception.AquariumException;
import fr.esgi.aquarium.domain.exception.EntityNotFoundException;
import fr.esgi.aquarium.domain.exception.ExceptionCode;
import fr.esgi.aquarium.domain.model.Space;
import fr.esgi.aquarium.domain.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Primary
public class SpringDataSpaceRepository implements SpaceRepository {

    private final JPASpaceRepository SpaceRepository;
    private final SpaceMapper mapper;

    @Override
    public Space findById(Long typeId) {
        var Space = SpaceRepository.findById(typeId);
        if (Space.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return mapper.toModel(Space.get());
    }

    @Override
    public void deleteById(Long typeId) {
        SpaceRepository.deleteById(typeId);
    }

    @Override
    public Space findByName(String name) {
        var Space = SpaceRepository.findByName(name);
        if (Space.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return mapper.toModel(Space.get());
    }

    @Override
    public List<Space> findAll() {
        return SpaceRepository.findAll().stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Space save(Space Space) {
        if (SpaceRepository.findByName(Space.getName()).isPresent()) {
            throw new AquariumException(ExceptionCode.ENTITY_CREATION_ERROR);
        }
        return mapper.toModel(SpaceRepository.saveAndFlush(mapper.toEntity(Space)));
    }

    @Override
    public Space update(Space Space) {
        if (SpaceRepository.findById(Space.getId()).isEmpty()) {
            throw new AquariumException(ExceptionCode.MODIFICATION_IMPOSSIBLE);
        }
        return mapper.toModel(SpaceRepository.saveAndFlush(mapper.toEntity(Space)));
    }
}
