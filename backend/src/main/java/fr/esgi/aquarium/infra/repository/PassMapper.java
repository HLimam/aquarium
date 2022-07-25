package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.model.Pass;
import fr.esgi.aquarium.infra.repository.entity.PassEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PassMapper {
    private final ModelMapper modelMapper;

    public PassEntity toEntity(Pass pass) {
        return modelMapper.map(pass, PassEntity.class);
    }

    public Pass toModel(PassEntity entity) {
        return modelMapper.map(entity, Pass.class);
    }
}
