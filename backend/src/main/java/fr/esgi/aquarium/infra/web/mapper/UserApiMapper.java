package fr.esgi.aquarium.infra.web.mapper;


import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.infra.web.request.RegistrationRequest;
import fr.esgi.aquarium.infra.web.request.UserRequest;
import fr.esgi.aquarium.infra.web.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserApiMapper {

    public static User convertToModel(UserRequest userRequest) {
        return new ModelMapper().map(userRequest, User.class);
    }

    public static User convertToModel(RegistrationRequest userRequest) {
        return new ModelMapper().map(userRequest, User.class);
    }

    public static UserResponse convertToResponseDto(User user) {
        return new ModelMapper().map(user, UserResponse.class);
    }




}
