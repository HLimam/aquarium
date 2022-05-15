package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.model.Space;
import fr.esgi.aquarium.infra.repository.entity.SpaceEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class SpaceMapper {
    private final ModelMapper modelMapper;
    public SpaceEntity toEntity(Space Space) {
        return modelMapper.map(Space,SpaceEntity.class);
    }

    public  Space toModel(SpaceEntity entity)  {
        return modelMapper.map(entity,Space.class);
    }
}
