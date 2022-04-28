package fr.esgi.aquarium.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    private Long      maintenanceId;
    private LocalDate dateHourStart;
    private LocalDate dateHourEnd;
    private Long      spaceId;
    private Long      managerId;

}
