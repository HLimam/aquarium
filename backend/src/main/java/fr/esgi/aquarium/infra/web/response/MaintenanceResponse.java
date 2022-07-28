package fr.esgi.aquarium.infra.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceResponse {

    private Long maintenanceId;
    private LocalDateTime dateHourStart;
    private LocalDateTime dateHourEnd;
    private Long spaceId;
    private Long managerId;

}
