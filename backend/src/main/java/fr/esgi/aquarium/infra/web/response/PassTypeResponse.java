package fr.esgi.aquarium.infra.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassTypeResponse {
    private Long id;
    private String name;
    private Double price;
    private Boolean isAvailable;
}
