package fr.esgi.aquarium.infra.web.mapper;


import fr.esgi.aquarium.domain.enumeration.PassType;
import fr.esgi.aquarium.domain.model.Pass;
import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.infra.web.request.PassRequest;
import fr.esgi.aquarium.infra.web.request.UpdatePassRequest;
import fr.esgi.aquarium.infra.web.response.PassResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PassApiMapper {

    public static Pass convertToModel(PassRequest passRequest) {
        var pass = new Pass();
        pass.setUser(User.builder().id(passRequest.getUserId()).build());
        pass.setType(PassType.fromName(passRequest.getType()));
        pass.setDateHourPurchase(passRequest.getDateHourPurchase());
        return pass;
    }

    public static Pass convertToModel(UpdatePassRequest passRequest) {
        var pass = new Pass();
        pass.setId(passRequest.getId());
        pass.setDateHourPeremption(passRequest.getDateHourPeremption());
        pass.setIsAvailable(passRequest.getIsAvailable());
        pass.setUser(User.builder().id(passRequest.getUserId()).build());
        pass.setType(PassType.fromName(passRequest.getType()));
        pass.setDateHourPurchase(passRequest.getDateHourPurchase());
        return pass;
    }

    public static PassResponse convertToResponseDto(Pass pass) {
        return new ModelMapper().map(pass, PassResponse.class);
    }
}
