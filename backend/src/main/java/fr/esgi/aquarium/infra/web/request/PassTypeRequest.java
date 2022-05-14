package fr.esgi.aquarium.infra.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassTypeRequest {

    @NotBlank(message = "Fill pass type.")
    private String name;

    @NotBlank(message = "Fill pass type price.")
    private Double price;

    private Boolean isAvailable;

}
