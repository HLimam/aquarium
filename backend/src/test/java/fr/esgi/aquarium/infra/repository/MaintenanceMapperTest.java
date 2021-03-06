package fr.esgi.aquarium.infra.repository;

import static org.junit.Assert.assertEquals;

import fr.esgi.aquarium.domain.model.Maintenance;
import fr.esgi.aquarium.infra.repository.entity.MaintenanceEntity;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MaintenanceMapperTest {

    @Autowired
    private MaintenanceMapper maintenanceMapper;

    @Test
    public void toModel() {
        MaintenanceEntity maintenanceEntity = new MaintenanceEntity();
        maintenanceEntity.setMaintenanceId(1L);
        maintenanceEntity.setDateHourStart(LocalDateTime.of(2022, 3, 24, 0, 0));
        maintenanceEntity.setDateHourStart(LocalDateTime.of(2022, 3, 24, 0, 0));
        maintenanceEntity.setSpaceId(1L);
        maintenanceEntity.setManagerId(1L);

        Maintenance maintenance = maintenanceMapper.toModel(maintenanceEntity);
        assertEquals(maintenance.getMaintenanceId(), maintenanceEntity.getMaintenanceId());
        assertEquals(maintenance.getDateHourStart(), maintenanceEntity.getDateHourStart());
        assertEquals(maintenance.getDateHourEnd(), maintenanceEntity.getDateHourEnd());
        assertEquals(maintenance.getSpaceId(), maintenanceEntity.getSpaceId());
        assertEquals(maintenance.getManagerId(), maintenanceEntity.getManagerId());
    }

    @Test
    public void toEntity() {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(1L);
        maintenance.setDateHourStart(LocalDateTime.of(2022, 3, 24, 0, 0));
        maintenance.setDateHourStart(LocalDateTime.of(2022, 3, 24, 0, 0));
        maintenance.setSpaceId(1L);
        maintenance.setManagerId(1L);

        MaintenanceEntity maintenanceEntity = maintenanceMapper.toEntity(maintenance);
        assertEquals(maintenanceEntity.getMaintenanceId(), maintenance.getMaintenanceId());
        assertEquals(maintenanceEntity.getDateHourStart(), maintenance.getDateHourStart());
        assertEquals(maintenanceEntity.getDateHourEnd(), maintenance.getDateHourEnd());
        assertEquals(maintenanceEntity.getSpaceId(), maintenance.getSpaceId());
        assertEquals(maintenanceEntity.getManagerId(), maintenance.getManagerId());
    }
}
