package fr.esgi.aquarium.infra.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.aquarium.domain.enumeration.PassType;
import fr.esgi.aquarium.infra.web.request.PassRequest;
import fr.esgi.aquarium.infra.web.request.UpdatePassRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
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
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static fr.esgi.aquarium.util.TestConstants.*;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WithUserDetails(ADMIN_EMAIL)
@TestPropertySource("/application.properties")
@Sql(value = {"/sql/create-user-before.sql","/sql/create-pass-before.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/sql/create-pass-after.sql","/sql/create-user-after.sql"},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class PassControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ObjectMapper mapper;
    private PassRequest passRequest;

    @Before
    public void init() {
        passRequest = new PassRequest();
        passRequest.setType(PassType.MONTHLY.getName());
        passRequest.setUserId(2L);
        passRequest.setDateHourPurchase(LocalDateTime.now());
    }

    @Test
    public void getAllPasses() throws Exception {
        mockMvc.perform(get(URL_PASS_BASIC))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id", hasItem(PASS_ID)))
                .andExpect(jsonPath("$[*].user.id", hasItem(USER_ID)))
                .andExpect(jsonPath("$[*].type", hasItem(PASS_TYPE)))
                .andExpect(jsonPath("$[*].isAvailable", hasItem(PASS_AVAILABLE)));
    }

    @Test
    public void getPassById() throws Exception {
        mockMvc.perform(get(URL_PASS_BASIC + "/" + PASS_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(PASS_ID))
                .andExpect(jsonPath("$.user.id").value(USER_ID))
                .andExpect(jsonPath("$.type").value(PASS_TYPE))
                .andExpect(jsonPath("$.isAvailable").value(PASS_AVAILABLE));
    }

    @Test
    public void deletePassById() throws Exception {
        mockMvc.perform(delete(URL_PASS_BASIC + "/" + PASS_ID))
                .andExpect(status().isNoContent());
    }

    @Test
    public void addPass() throws Exception {
        mockMvc.perform(post(URL_PASS_BASIC).content(mapper.writeValueAsString(passRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());
    }

    @Test
    public void updatePass() throws Exception {
        var passRequest2 = UpdatePassRequest.builder()
                .id(100L)
                .userId(2L)
                .type(PassType.DAILY.getName())
                .isAvailable(Boolean.TRUE)
                .dateHourPurchase(LocalDateTime.now().plusDays(2))
                .dateHourPeremption(LocalDateTime.now().plusDays(3))
                .build();
        mockMvc.perform(put(URL_PASS_BASIC)
                        .content(mapper.writeValueAsString(passRequest2))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void updatePassAvailability() throws Exception {
        mockMvc.perform(patch(URL_PASS_BASIC + "/" + PASS_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isAvailable").value(Boolean.FALSE));
    }
}
