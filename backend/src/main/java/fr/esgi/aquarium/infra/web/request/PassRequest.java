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
public class PassRequest {

    @NotBlank(message = "Fill user Id.")
    private Long userId;
    @NotBlank(message = "Fill pass type.")
    private String type;
}
