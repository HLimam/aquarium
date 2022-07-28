package fr.esgi.aquarium.infra.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassRequest {

    @NotNull(message = "Fill user Id.")
    private Long userId;
    @NotNull(message = "Fill pass type.")
    private String type;
    @NotNull(message = "Fill date purchase.")
    private LocalDateTime dateHourPurchase;

}
