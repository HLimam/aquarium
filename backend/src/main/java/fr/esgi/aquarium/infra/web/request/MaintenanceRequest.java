package fr.esgi.aquarium.infra.web.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MaintenanceRequest {
    @NotBlank()
    private Long spaceId;

    @NotBlank()
    private Long managerId;
}
