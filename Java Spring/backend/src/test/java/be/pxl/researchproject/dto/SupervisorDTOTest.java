package be.pxl.researchproject.dto;

import be.pxl.researchproject.api.dto.SupervisorDTO;
import be.pxl.researchproject.model.Supervisor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupervisorDTOTest {
    private final String title = "Vice president", name = "Smith", firstName = "Tyrone", phoneNumber = "56564412", email ="Tyrone@gmail.com";

    private SupervisorDTO supervisorDTO;

    @BeforeEach
    public void init() {
        Supervisor supervisor = new Supervisor();
        supervisor.setTitle(title);
        supervisor.setName(name);
        supervisor.setFirstName(firstName);
        supervisor.setPhoneNumber(phoneNumber);
        supervisor.setEmail(email);
        this.supervisorDTO = new SupervisorDTO(supervisor);
    }

    @Test
    public void testGetters() {
        assertEquals(supervisorDTO.getTitle(), title);
        assertEquals(supervisorDTO.getName(), name);
        assertEquals(supervisorDTO.getFirstName(), firstName);
        assertEquals(supervisorDTO.getPhoneNumber(), phoneNumber);
        assertEquals(supervisorDTO.getEmail(), email);
    }
}
