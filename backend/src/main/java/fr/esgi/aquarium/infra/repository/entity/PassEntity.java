package fr.esgi.aquarium.infra.repository.entity;

import fr.esgi.aquarium.domain.enumeration.PassType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pass")
public class PassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pass_id_seq")
    @SequenceGenerator(name = "pass_id_seq", sequenceName = "pass_id_seq", initialValue = 1, allocationSize = 1)
    private Long Id;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_pass_user_id"), nullable = false)
    private UserEntity user;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PassType type;
    private LocalDateTime dateHourPurchase;
    private LocalDateTime dateHourPeremption;
    private Boolean isAvailable;
}
