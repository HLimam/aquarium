package fr.esgi.aquarium.infra.web.mapper;


import fr.esgi.aquarium.domain.enumeration.SpaceType;
import fr.esgi.aquarium.domain.model.PassType;
import fr.esgi.aquarium.domain.model.Space;
import fr.esgi.aquarium.infra.web.request.PassTypeRequest;
import fr.esgi.aquarium.infra.web.request.SpaceRequest;
import fr.esgi.aquarium.infra.web.request.UpdatePassTypeRequest;
import fr.esgi.aquarium.infra.web.request.UpdateSpaceRequest;
import fr.esgi.aquarium.infra.web.response.PassTypeResponse;
import fr.esgi.aquarium.infra.web.response.SpaceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SpaceApiMapper {

    public static Space convertToModel(SpaceRequest spaceRequest) {
        var space = new ModelMapper().map(spaceRequest, Space.class);
        space.setType(SpaceType.fromName(spaceRequest.getType()));
        return space;
    }

    public static Space convertToModel(UpdateSpaceRequest spaceRequest) {
        var space = new ModelMapper().map(spaceRequest, Space.class);
        space.setType(SpaceType.fromName(spaceRequest.getType()));
        return space;
    }

    public static SpaceResponse convertToResponseDto(Space space) {
        var spaceResponse =new ModelMapper().map(space, SpaceResponse.class);
        spaceResponse.setType(space.getType().getName());
        return spaceResponse;
    }
}
