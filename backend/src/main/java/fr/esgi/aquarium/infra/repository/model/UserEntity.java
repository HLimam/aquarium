package fr.esgi.aquarium.infra.repository.model;

import fr.esgi.aquarium.domain.AuthProvider;
import fr.esgi.aquarium.domain.Role;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", initialValue = 1, allocationSize = 1)
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
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}
