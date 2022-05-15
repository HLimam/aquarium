package fr.esgi.aquarium.domain.model;

import fr.esgi.aquarium.infra.repository.entity.SpaceTypeEntity;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Space {

    private Long   spaceId;
    private String   spaceName;
    private String   description;
    private Integer   spaceCapacity;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private Boolean   handicappedAccess;
    private SpaceTypeEntity spaceType;
    
}
