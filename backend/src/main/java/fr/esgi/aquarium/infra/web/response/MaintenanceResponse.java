package fr.esgi.aquarium.infra.web.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MaintenanceResponse {

    private Long          maintenanceId;
    private LocalDateTime dateHourStart;
    private LocalDateTime     dateHourEnd;
    private Long      spaceId;
    private Long      managerId;

}
