package fr.esgi.aquarium.infra.web.mapper;


import fr.esgi.aquarium.domain.enumeration.SpaceType;
import fr.esgi.aquarium.domain.model.Fish;
import fr.esgi.aquarium.domain.model.Space;
import fr.esgi.aquarium.infra.web.request.FishRequest;
import fr.esgi.aquarium.infra.web.request.SpaceRequest;
import fr.esgi.aquarium.infra.web.request.UpdateSpaceRequest;
import fr.esgi.aquarium.infra.web.response.FishResponse;
import fr.esgi.aquarium.infra.web.response.SpaceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FishApiMapper {

    public static Fish convertToModel(FishRequest fishRequest) {
        return new ModelMapper().map(fishRequest, Fish.class);
    }

    public static FishResponse convertToResponseDto(Fish fish) {
        return new ModelMapper().map(fish, FishResponse.class);
    }
}
