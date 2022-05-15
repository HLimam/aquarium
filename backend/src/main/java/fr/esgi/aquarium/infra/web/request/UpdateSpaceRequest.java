package fr.esgi.aquarium.infra.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateSpaceRequest {
    @NotBlank(message = "Fill pass id.")
    private Long   id;
    private String   name;
    private String   description;
    private Integer   capacity;
    private LocalDate openingTime;
    private LocalDate closingTime;
    private Boolean disabledAccess;
    private String type;
}
