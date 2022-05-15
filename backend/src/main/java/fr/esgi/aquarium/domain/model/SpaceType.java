package fr.esgi.aquarium.domain.model;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpaceType {

    private Long   spaceTypeId;
    private String   spaceTypeLibelle;

}
