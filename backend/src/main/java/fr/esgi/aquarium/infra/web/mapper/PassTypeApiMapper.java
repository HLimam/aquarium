package fr.esgi.aquarium.infra.web.mapper;


import fr.esgi.aquarium.domain.model.PassType;
import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.infra.web.request.PassTypeRequest;
import fr.esgi.aquarium.infra.web.request.RegistrationRequest;
import fr.esgi.aquarium.infra.web.request.UpdatePassTypeRequest;
import fr.esgi.aquarium.infra.web.request.UserRequest;
import fr.esgi.aquarium.infra.web.response.PassTypeResponse;
import fr.esgi.aquarium.infra.web.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PassTypeApiMapper {

    public static PassType convertToModel(PassTypeRequest passTypeRequest) {
        return new ModelMapper().map(passTypeRequest, PassType.class);
    }

    public static PassType convertToModel(UpdatePassTypeRequest passTypeRequest) {
        return new ModelMapper().map(passTypeRequest, PassType.class);
    }

    public static PassTypeResponse convertToResponseDto(PassType passType) {
        return new ModelMapper().map(passType, PassTypeResponse.class);
    }
}
