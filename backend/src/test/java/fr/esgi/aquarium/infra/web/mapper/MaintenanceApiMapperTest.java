package fr.esgi.aquarium.infra.web.mapper;

import static org.junit.Assert.assertEquals;

import fr.esgi.aquarium.domain.model.Maintenance;
import fr.esgi.aquarium.infra.web.response.MaintenanceResponse;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MaintenanceApiMapperTest {

    @Autowired
    private MaintenanceApiMapper maintenanceApiMapper;

    @Test
    public void convertToResponseDto() {
        Maintenance maintenance = new Maintenance();
        maintenance.setSpaceId(1L);
        maintenance.setManagerId(1L);

        MaintenanceResponse maintenanceResponse = maintenanceApiMapper.convertToResponseDto(maintenance);
        assertEquals(maintenanceResponse.getSpaceId(), maintenance.getSpaceId());
        assertEquals(maintenanceResponse.getManagerId(), maintenance.getManagerId());
    }

    @Test
    public void findAllMaintenances() {
        List<MaintenanceResponse> maintenanceResponses = maintenanceApiMapper.findAllMaintenances();
        assertEquals(List.of(), maintenanceResponses);
    }
}
