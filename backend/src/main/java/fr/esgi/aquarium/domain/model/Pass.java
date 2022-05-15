package fr.esgi.aquarium.domain.model;

import fr.esgi.aquarium.domain.enumeration.PassType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pass {
    private Long Id;
    private User user;
    private PassType type;
    private LocalDateTime dateHourPurchase;
    private LocalDateTime dateHourPeremption;
    private Boolean isAvailable;
}
