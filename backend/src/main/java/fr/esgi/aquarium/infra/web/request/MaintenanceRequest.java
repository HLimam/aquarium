package fr.esgi.aquarium.infra.web.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class MaintenanceRequest {
    @NotNull()
    private String maintenanceId;

    @NotNull()
    private LocalDateTime dateHourStart;

    @NotNull()
    private Long spaceId;

    @NotNull()
    private Long managerId;
}
