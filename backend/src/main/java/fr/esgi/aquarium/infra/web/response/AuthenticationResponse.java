package fr.esgi.aquarium.infra.web.response;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String email;
    private String token;
    private String userRole;
}
