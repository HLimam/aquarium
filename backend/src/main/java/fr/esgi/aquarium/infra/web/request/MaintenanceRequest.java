package fr.esgi.aquarium.infra.web.request;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.Data;

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
