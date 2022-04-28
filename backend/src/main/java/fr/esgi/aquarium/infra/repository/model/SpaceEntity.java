package fr.esgi.aquarium.infra.repository.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "space")
public class SpaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "space_type_seq")
    @SequenceGenerator(name = "space_type_seq", sequenceName = "space_type_seq", initialValue = 1, allocationSize = 1)
    private Long   spaceId;

    @Column(name = "space_name")
    private String   spaceName;

    @Column(name = "description")
    private String   description;

    @Column(name = "space_capacity")
    private Integer   spaceCapacity;

    @Column(name = "opening_time")
    private LocalDate openingTime;

    @Column(name = "closing_time")
    private LocalDate closingTime;

    @Column(name = "handicappedacces")
    private Boolean   handicappedAccess;

    @ManyToOne()
    @JoinColumn(name = "space_type_id")
    private SpaceTypeEntity spaceType;
}
