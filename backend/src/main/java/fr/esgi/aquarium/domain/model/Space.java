package fr.esgi.aquarium.domain.model;

import fr.esgi.aquarium.domain.enumeration.SpaceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Space {
    private Long id;
    private String name;
    private String description;
    private Integer capacity;
    private LocalDate openingTime;
    private LocalDate closingTime;
    private Boolean disabledAccess;
    private SpaceType type;

}
