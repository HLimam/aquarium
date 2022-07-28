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
@Builder
public class UpdatePassRequest {
    @NotNull(message = "Fill pass Id.")
    private Long id;
    private Long userId;
    private String type;
    private LocalDateTime dateHourPurchase;
    private LocalDateTime dateHourPeremption;
    private Boolean isAvailable;

}
