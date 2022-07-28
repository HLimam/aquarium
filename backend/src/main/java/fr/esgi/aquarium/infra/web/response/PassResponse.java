package fr.esgi.aquarium.infra.web.response;

import fr.esgi.aquarium.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassResponse {
    private Long Id;
    private User user;
    private String type;
    private LocalDateTime dateHourPurchase;
    private LocalDateTime dateHourPeremption;
    private Boolean isAvailable;
}
