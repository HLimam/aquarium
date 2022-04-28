package fr.esgi.aquarium.infra.web.mapper;


import fr.esgi.aquarium.domain.Maintenance;
import fr.esgi.aquarium.domain.MaintenanceService;
import fr.esgi.aquarium.infra.web.request.MaintenanceRequest;
import fr.esgi.aquarium.infra.web.response.MaintenanceResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceApiMapper {

    private final ModelMapper        modelMapper;
    private final MaintenanceService maintenanceService;

    public MaintenanceApiMapper(@Lazy MaintenanceService maintenanceService, ModelMapper modelMapper) {
        this.maintenanceService = maintenanceService;
        this.modelMapper = modelMapper;
    }

    public MaintenanceResponse convertToResponseDto(Maintenance maintenance) {
        return modelMapper.map(maintenance, MaintenanceResponse.class);
    }

    private Maintenance convertToEntity(MaintenanceRequest maintenanceRequest) {
        return modelMapper.map(maintenanceRequest, Maintenance.class);
    }

    public List<MaintenanceResponse> findAllMaintenances() {
        return maintenanceService.findAllMaintenances().stream().map(this::convertToResponseDto)
                                 .collect(Collectors.toList());
    }

//    public MaintenanceResponse findMaintenanceById(Long maintenanceId) {
//        return convertToResponseDto(maintenanceService.findMaintenanceById(maintenanceId));
//    }
//
//    public MaintenanceResponse findMaintenanceByManagerId(Long managerId) {
//        return convertToResponseDto(maintenanceService.findMaintenanceByManagerId(email));
//    }
//
//    public MaintenanceResponse findMaintenanceBySpaceId(Long spaceId) {
//        return convertToResponseDto(maintenanceService.findMaintenanceBySpaceId(email));
//    }
//
//    public MaintenanceResponse closeMaintenanceById(Long maintenanceId) {
//        return convertToResponseDto(maintenanceService.closeMaintenanceById(maintenanceId));
//    }
//
//    public MaintenanceResponse deleteMaintenanceById(Long maintenanceId) {
//        return convertToResponseDto(maintenanceService.deleteMaintenanceById(maintenanceId));
//    }
//
//    public MaintenanceResponse createMaintenanceById(MaintenanceRequest maintenanceRequest) {
//        return convertToResponseDto(maintenanceService.createMaintenanceById(convertToEntity(maintenanceRequest)));
//    }
}
