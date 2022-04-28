package fr.esgi.aquarium.infra.web.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MaintenanceResponse {

    private Long      maintenanceId;
    private LocalDate dateHourStart;
    private LocalDate dateHourEnd;
    private Long      spaceId;
    private Long      managerId;

}
