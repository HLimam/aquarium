package fr.esgi.aquarium.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    private Long          maintenanceId;
    private LocalDateTime dateHourStart;
    private LocalDateTime dateHourEnd;
    private Long          spaceId;
    private Long          managerId;

}
