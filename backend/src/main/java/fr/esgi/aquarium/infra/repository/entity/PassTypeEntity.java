package fr.esgi.aquarium.infra.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passTpe")
public class PassTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pass_type_id_seq")
    @SequenceGenerator(name = "pass_type_id_seq", sequenceName = "pass_type_id_seq", initialValue = 1, allocationSize = 1)
    private Long Id;
    private String name;
    private Double price;
    private Boolean isAvailable;
}
