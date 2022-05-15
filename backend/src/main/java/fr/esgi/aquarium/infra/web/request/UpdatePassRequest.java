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
public class UpdatePassRequest {
    @NotBlank(message = "Fill pass id.")
    private Long Id;
    private Long userId;
    private String type;
    private LocalDateTime dateHourPurchase;
    private LocalDateTime dateHourPeremption;
    private Boolean isAvailable;

}
