package fr.esgi.aquarium.infra.repository.entity;

import fr.esgi.aquarium.domain.enumeration.SpaceType;
import fr.esgi.aquarium.domain.model.Space;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "fish")
public class FishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fish_seq")
    @SequenceGenerator(name = "fish_seq", sequenceName = "fish_seq", initialValue = 1, allocationSize = 1)
    private Long   id;

    @Column(name = "name")
    private String   name;

    @Column(name = "scientificName")
    private String   scientificName;

    @ManyToMany(mappedBy = "fishes")
    private List<SpaceEntity> spaces;

}
