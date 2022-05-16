package fr.esgi.aquarium.infra.repository.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

import fr.esgi.aquarium.domain.enumeration.SpaceType;
import fr.esgi.aquarium.domain.model.Fish;
import lombok.Data;

@Data
@Entity
@Table(name = "space")
public class SpaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "space_seq")
    @SequenceGenerator(name = "space_seq", sequenceName = "space_seq", initialValue = 1, allocationSize = 1)
    private Long   id;

    @Column(name = "name")
    private String   name;

    @Column(name = "description")
    private String   description;

    @Column(name = "capacity")
    private Integer   capacity;

    @Column(name = "opening_time")
    private LocalDate openingTime;

    @Column(name = "closing_time")
    private LocalDate closingTime;

    @Column(name = "disabled_access")
    private Boolean   disabledAccess;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private SpaceType type;

    @ManyToMany
    private List<FishEntity> fishes;
}
