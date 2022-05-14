package fr.esgi.aquarium.infra.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "space_type")
public class SpaceTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "space_type_seq")
    @SequenceGenerator(name = "space_type_seq", sequenceName = "space_type_seq", initialValue = 1, allocationSize = 1)
    private Long   spaceTypeId;

    @Column(name = "space_type_libelle")
    private String   spaceTypeLibelle;
}
