package fr.esgi.aquarium.infra.web.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import fr.esgi.aquarium.domain.model.Maintenance;
import fr.esgi.aquarium.domain.repository.MaintenanceRepository;
import fr.esgi.aquarium.infra.service.MaintenanceService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MaintenanceServiceTest {

    @Autowired
    private MaintenanceService maintenanceService;

    @MockBean
    private MaintenanceRepository maintenanceRepository;

    @Test
    public void findAllMaintenances() {
        List<Maintenance> maintenances = new ArrayList<>() {{
            add(new Maintenance(1L, LocalDate.of(2022, 3, 24), LocalDate.of(2022, 3, 27), 1L, 1L));
            add(new Maintenance(2L, LocalDate.of(2022, 3, 24), LocalDate.of(2022, 3, 25), 2L, 2L));
        }};

        when(maintenanceRepository.findAllMaintenances()).thenReturn(maintenances);
        List<Maintenance> maintenancesResult = maintenanceService.findAllMaintenances();
        assertEquals(maintenancesResult.size(), maintenances.size());
        assertEquals(maintenancesResult.get(0).getMaintenanceId(), maintenances.get(0).getMaintenanceId());
        assertEquals(maintenancesResult.get(1).getMaintenanceId(), maintenances.get(1).getMaintenanceId());

        verify(maintenanceRepository, times(1)).findAllMaintenances();
    }

//    @Test
//    public void findMaintenanceById() {
//        Maintenance maintenance = new Maintenance();
//        maintenance.setId(122L);
//
//        when(maintenanceRepository.findById(122L)).thenReturn(maintenance);
//        maintenanceService.findMaintenanceById(122L);
//        assertEquals(Long.valueOf(122L), maintenance.getId());
//        verify(maintenanceRepository, times(1)).findById(122L);
//    }
//
//    @Test
//    public void findMaintenanceByEmail() {
//        Maintenance maintenance = new Maintenance();
//        maintenance.setEmail(USER_EMAIL);
//        maintenanceService.findMaintenanceByEmail(USER_EMAIL);
//
//        when(maintenanceRepository.findByEmail(USER_EMAIL)).thenReturn(maintenance);
//        assertEquals(USER_EMAIL, maintenance.getEmail());
//        verify(maintenanceRepository, times(1)).findByEmail(USER_EMAIL);
//    }
//
//    @Test
//    public void findAllMaintenances() {
//        List<Maintenance> maintenancesList = new ArrayList<>();
//        maintenancesList.add(new Maintenance());
//        maintenancesList.add(new Maintenance());
//        maintenanceService.findAllMaintenances();
//
//        when(maintenanceRepository.findAllByOrderByIdAsc()).thenReturn(maintenancesList);
//        assertEquals(2, maintenancesList.size());
//        verify(maintenanceRepository, times(1)).findAllByOrderByIdAsc();
//    }
//
//
//    @Test
//    public void loadMaintenanceByMaintenancename() {
//        Maintenance maintenance = new Maintenance();
//        maintenance.setEmail(USER_EMAIL);
//        maintenance.setActive(true);
//        maintenance.setFirstName(FIRST_NAME);
//        maintenance.setRoles(Collections.singleton(Role.USER));
//
//        when(maintenanceRepository.findByEmail(USER_EMAIL)).thenReturn(maintenance);
//        assertEquals(USER_EMAIL, maintenance.getEmail());
//        assertEquals(FIRST_NAME, maintenance.getFirstName());
//        assertTrue(maintenance.isActive());
//    }
//
//    @Test
//    public void updateProfile() {
//        Maintenance maintenance = new Maintenance();
//        maintenance.setEmail(USER_EMAIL);
//        maintenance.setFirstName(FIRST_NAME);
//
//        when(maintenanceRepository.findByEmail(USER_EMAIL)).thenReturn(maintenance);
//        when(maintenanceRepository.save(maintenance)).thenReturn(maintenance);
//        maintenanceService.updateProfile(USER_EMAIL, maintenance);
//        assertEquals(USER_EMAIL, maintenance.getEmail());
//        assertEquals(FIRST_NAME, maintenance.getFirstName());
//        verify(maintenanceRepository, times(1)).findByEmail(maintenance.getEmail());
//        verify(maintenanceRepository, times(1)).save(maintenance);
//    }

}
