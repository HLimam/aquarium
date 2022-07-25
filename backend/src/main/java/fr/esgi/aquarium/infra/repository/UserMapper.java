package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.infra.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserMapper {
    private final ModelMapper modelMapper;

    public UserEntity toEntity(User user) {
        return modelMapper.map(user, UserEntity.class);
    }

    public User toModel(UserEntity entity) {
        return modelMapper.map(entity, User.class);
    }
}
