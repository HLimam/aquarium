package fr.esgi.aquarium.infra.web.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String email;
    private String token;
    private String userRole;
}
