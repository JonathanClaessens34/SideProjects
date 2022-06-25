package be.pxl.researchproject.request;

import be.pxl.researchproject.api.request.SupervisorRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupervisorRequestTest {
    private String title = "Vice president", name = "Shakur", firstName = "Tupac", phoneNumber = "5646545656", email = "Tupac@gmail.com";
    private SupervisorRequest supervisorRequest;

    @BeforeEach
    public void init() {
        supervisorRequest = new SupervisorRequest(title, name, firstName, phoneNumber, email);
        supervisorRequest.setTitle(title);
        supervisorRequest.setName(name);
        supervisorRequest.setFirstName(firstName);
        supervisorRequest.setPhoneNumber(phoneNumber);
        supervisorRequest.setEmail(email);
    }

    @Test
    public void testGetters() {
        assertEquals(supervisorRequest.getTitle(), title);
        assertEquals(supervisorRequest.getName(), name);
        assertEquals(supervisorRequest.getFirstName(), firstName);
        assertEquals(supervisorRequest.getPhoneNumber(), phoneNumber);
        assertEquals(supervisorRequest.getEmail(), email);

    }
}
