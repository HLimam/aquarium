package fr.esgi.aquarium.infra.api;

import static fr.esgi.aquarium.util.TestConstants.*;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WithUserDetails(ADMIN_EMAIL)
@TestPropertySource("/application.properties")
@Sql(value = {"/sql/create-user-before.sql","/sql/create-space-before.sql","/sql/create-maintenance-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/create-user-after.sql","/sql/create-space-after.sql","/sql/create-maintenance-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

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
        maintenanceRequest.setManagerId(2L);
        maintenanceRequest.setSpaceId(1L);
    }

    @Test
    public void getAllMaintenances() throws Exception {
        mockMvc.perform(get("/api/v1/maintenance"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].maintenanceId", hasItem(1)))
                .andExpect(jsonPath("$[*].managerId", hasItem(2)))
                .andExpect(jsonPath("$[*].spaceId", hasItem(1)));
    }

    @Test
    public void getMaintenanceById() throws Exception {
        mockMvc.perform(get("/api/v1/maintenance/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.maintenanceId").value(1))
                .andExpect(jsonPath("$.managerId").value(2))
                .andExpect(jsonPath("$.spaceId").value(1));
    }

    @Test
    public void getMaintenanceByManagerId() throws Exception {
        mockMvc.perform(get("/api/v1/maintenance/manager/2")).andExpect(status().isOk())
                .andExpect(jsonPath("$[*].maintenanceId", hasItem(1)))
                .andExpect(jsonPath("$[*].managerId", hasItem(2)))
                .andExpect(jsonPath("$[*].spaceId", hasItem(1)));
    }

    @Test
    public void getMaintenanceBySpaceId() throws Exception {
        mockMvc.perform(get("/api/v1/maintenance/space/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$[*].maintenanceId", hasItem(1)))
                .andExpect(jsonPath("$[*].managerId", hasItem(2)))
                .andExpect(jsonPath("$[*].spaceId", hasItem(1)));
    }

    @Test
    public void closeMaintenanceById() throws Exception {
        mockMvc.perform(put("/api/v1/maintenance/close/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.maintenanceId").value(1))
                .andExpect(jsonPath("$.managerId").value(2))
                .andExpect(jsonPath("$.spaceId").value(1));
    }

    @Test
    public void createMaintenance() throws Exception {
        mockMvc.perform(post("/api/v1/maintenance").content(mapper.writeValueAsString(maintenanceRequest))
                                                   .contentType(MediaType.APPLICATION_JSON_VALUE))
               .andExpect(status().isCreated());
    }
}
