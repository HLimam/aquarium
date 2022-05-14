package fr.esgi.aquarium.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassType {
    private Long Id;
    private String name;
    private Double price;
    private Boolean isAvailable;
}
