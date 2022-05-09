package fr.esgi.aquarium.infra.web.mapper;


import fr.esgi.aquarium.domain.model.Maintenance;
import fr.esgi.aquarium.infra.service.MaintenanceService;
import fr.esgi.aquarium.infra.web.request.MaintenanceRequest;
import fr.esgi.aquarium.infra.web.response.MaintenanceResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceApiMapper {

    public static MaintenanceResponse convertToResponseDto(Maintenance maintenance) {
        return new ModelMapper().map(maintenance, MaintenanceResponse.class);
    }

    public static Maintenance convertToModel(MaintenanceRequest maintenanceRequest) {
        return new ModelMapper().map(maintenanceRequest, Maintenance.class);
    }


}
