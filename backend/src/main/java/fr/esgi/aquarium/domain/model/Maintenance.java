package fr.esgi.aquarium.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    private Long maintenanceId;
    private LocalDateTime dateHourStart;
    private LocalDateTime dateHourEnd;
    private Long spaceId;
    private Long managerId;

}
