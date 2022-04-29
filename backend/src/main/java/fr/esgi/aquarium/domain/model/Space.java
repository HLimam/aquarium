package fr.esgi.aquarium.domain.model;

import fr.esgi.aquarium.infra.repository.model.SpaceTypeEntity;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private LocalDate openingTime;
    private LocalDate closingTime;
    private Boolean   handicappedAccess;
    private SpaceTypeEntity spaceType;
    
}
