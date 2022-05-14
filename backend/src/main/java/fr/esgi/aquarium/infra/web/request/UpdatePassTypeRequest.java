package fr.esgi.aquarium.infra.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePassTypeRequest {
    @NotBlank(message = "Fill pass id.")
    private Long Id;

    private String name;

    private Double price;

    private Boolean isAvailable;

}
