package fr.esgi.aquarium.infra.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.aquarium.infra.web.request.MaintenanceRequest;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/sql/create-user-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@Sql(value = {"/sql/create-space-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/create-space-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class MaintenanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private MaintenanceRequest maintenanceRequest;

    @Before
    public void init() {
        maintenanceRequest = new MaintenanceRequest();
        maintenanceRequest.setMaintenanceId("1");
        maintenanceRequest.setDateHourStart(LocalDateTime.of(2022, 8, 4, 0, 0));
        maintenanceRequest.setManagerId(1L);
        maintenanceRequest.setSpaceId(1L);
    }

    @Test
    public void getAllMaintenances() throws Exception {
        mockMvc.perform(get("/api/v1/maintenance")).andExpect(status().isOk());
    }

    @Test
    public void getMaintenanceById() throws Exception {
        mockMvc.perform(get("/api/v1/maintenance/100")).andExpect(status().isOk());
    }

    @Test
    public void getMaintenanceByManagerId() throws Exception {
        mockMvc.perform(get("/api/v1/maintenance/manager/1")).andExpect(status().isOk());
    }

    @Test
    public void getMaintenanceBySpaceId() throws Exception {
        mockMvc.perform(get("/api/v1/maintenance/space/100")).andExpect(status().isOk());
    }

    @Test
    public void closeMaintenanceById() throws Exception {
        mockMvc.perform(put("/api/v1/maintenance/close/1")).andExpect(status().isOk());
    }

    @Test
    public void createMaintenance() throws Exception {
        mockMvc.perform(post("/api/v1/maintenance").content(mapper.writeValueAsString(maintenanceRequest))
                                                   .contentType(MediaType.APPLICATION_JSON_VALUE))
               .andExpect(status().isOk());
    }
}
