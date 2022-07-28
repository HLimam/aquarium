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
public class SpaceResponse {
    private Long id;
    private String name;
    private String description;
    private Integer capacity;
    private LocalDate openingTime;
    private LocalDate closingTime;
    private Boolean disabledAccess;
    private String type;
}
