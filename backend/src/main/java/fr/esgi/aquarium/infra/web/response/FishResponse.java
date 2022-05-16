package fr.esgi.aquarium.infra.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FishResponse {
    private Long id;
    private String name;
    private String scientificName;
}
