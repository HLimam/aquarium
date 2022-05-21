package fr.esgi.aquarium.infra.web.request;

import fr.esgi.aquarium.domain.enumeration.PassType;
import fr.esgi.aquarium.domain.model.User;
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
public class PassRequest {

    @NotBlank(message = "Fill user Id.")
    private Long userId;
    @NotBlank(message = "Fill pass type.")
    private String type;
    @NotBlank(message = "Fill date purchase.")
    private LocalDateTime dateHourPurchase;
    @NotBlank(message = "Fill date peremption.")
    private LocalDateTime dateHourPeremption;
    private Boolean isAvailable;

}
