package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.model.Fish;
import fr.esgi.aquarium.domain.model.Space;
import fr.esgi.aquarium.infra.repository.entity.FishEntity;
import fr.esgi.aquarium.infra.repository.entity.SpaceEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class FishMapper {
    private final ModelMapper modelMapper;
    public FishEntity toEntity(Fish fish) {
        return modelMapper.map(fish,FishEntity.class);
    }

    public Fish toModel(FishEntity entity)  {
        return modelMapper.map(entity,Fish.class);
    }
}
