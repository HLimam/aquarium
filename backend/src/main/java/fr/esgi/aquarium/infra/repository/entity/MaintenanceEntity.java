package fr.esgi.aquarium.infra.repository.entity;

import java.time.LocalDateTime;
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
@Table(name = "maintenance")
public class MaintenanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maintenance_id_seq")
    @SequenceGenerator(name = "maintenance_id_seq", sequenceName = "maintenance_id_seq", initialValue = 1, allocationSize = 1)
    private Long   maintenanceId;

    @Column(name = "date_hour_start")
    private LocalDateTime dateHourStart;

    @Column(name = "date_hour_end")
    private LocalDateTime dateHourEnd;

    @Column(name = "space_id")
    private Long spaceId;

    @Column(name = "manager_id")
    private Long managerId;
}
