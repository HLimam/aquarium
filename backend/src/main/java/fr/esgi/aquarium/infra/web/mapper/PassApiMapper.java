package fr.esgi.aquarium.infra.web.mapper;


import fr.esgi.aquarium.domain.model.Pass;
import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.infra.web.request.PassRequest;
import fr.esgi.aquarium.infra.web.request.RegistrationRequest;
import fr.esgi.aquarium.infra.web.request.UpdatePassRequest;
import fr.esgi.aquarium.infra.web.request.UserRequest;
import fr.esgi.aquarium.infra.web.response.PassResponse;
import fr.esgi.aquarium.infra.web.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PassApiMapper {

    public static Pass convertToModel(PassRequest passRequest) {
        return new ModelMapper().map(passRequest, Pass.class);
    }

    public static Pass convertToModel(UpdatePassRequest PassRequest) {
        return new ModelMapper().map(PassRequest, Pass.class);
    }

    public static PassResponse convertToResponseDto(Pass pass) {
        return new ModelMapper().map(pass, PassResponse.class);
    }
}
