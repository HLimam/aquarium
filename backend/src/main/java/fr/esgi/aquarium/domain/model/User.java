package fr.esgi.aquarium.domain.model;

import fr.esgi.aquarium.domain.enumeration.AuthProvider;
import fr.esgi.aquarium.domain.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String phoneNumber;
    private String postIndex;
    private String activationCode;
    private String passwordResetCode;
    private boolean active;
    private LocalDate    date;
    private AuthProvider provider;
    private Set<Role>    roles;
}
