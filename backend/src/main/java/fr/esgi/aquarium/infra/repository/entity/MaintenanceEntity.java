package fr.esgi.aquarium.infra.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "maintenance")
public class MaintenanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maintenance_id_seq")
    @SequenceGenerator(name = "maintenance_id_seq", sequenceName = "maintenance_id_seq", initialValue = 1, allocationSize = 1)
    private Long maintenanceId;

    @Column(name = "date_hour_start")
    private LocalDateTime dateHourStart;

    @Column(name = "date_hour_end")
    private LocalDateTime dateHourEnd;

    @Column(name = "space_id")
    private Long spaceId;

    @Column(name = "manager_id")
    private Long managerId;
}
