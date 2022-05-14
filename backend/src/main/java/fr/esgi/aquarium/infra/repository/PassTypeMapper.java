package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.model.PassType;
import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.infra.repository.entity.PassTypeEntity;
import fr.esgi.aquarium.infra.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PassTypeMapper {
    private final ModelMapper modelMapper;
    public PassTypeEntity toEntity(PassType passType) {
        return modelMapper.map(passType,PassTypeEntity.class);
    }

    public  PassType toModel(PassTypeEntity entity)  {
        return modelMapper.map(entity,PassType.class);
    }
}
