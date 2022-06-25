package be.pxl.researchproject.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SupervisorTest {
    private Supervisor supervisor;

    private final String TITLE= "Accountant";
    private final String NAME = "Tyreese Gibson", FIRSTNAME = "Tyreese", PHONENUMBER = "54656556", EMAIL = "tyreese@gmail.com";

    @BeforeEach
    public void init() {
        supervisor = new Supervisor();
        supervisor.setTitle(TITLE);
        supervisor.setName(NAME);
        supervisor.setFirstName(FIRSTNAME);
        supervisor.setPhoneNumber(PHONENUMBER);
        supervisor.setEmail(EMAIL);
    }

    @Test
    public void testSetters() {
        assertEquals(supervisor.getTitle(), TITLE);
        assertEquals(supervisor.getName(), NAME);
        assertEquals(supervisor.getFirstName(), FIRSTNAME);
        assertEquals(supervisor.getPhoneNumber(), PHONENUMBER);
        assertEquals(supervisor.getEmail(), EMAIL);
    }

    @Test
    public void testEqualsSameCompany() {
        Supervisor contactPerson2 = supervisor;
        assertTrue(supervisor.equals(contactPerson2));
    }

    @Test
    public void testEqualsNullAndOtherClass() {
        String a = "";
        assertFalse(supervisor.equals(null));
        assertFalse(supervisor.equals(a));
    }

    @Test
    public void testEquals() {
        Supervisor supervisor2 = new Supervisor();
        supervisor2.setTitle(TITLE);
        supervisor2.setName(NAME);
        supervisor2.setFirstName(FIRSTNAME);
        supervisor2.setPhoneNumber(PHONENUMBER);
        supervisor2.setEmail(EMAIL);
        assertTrue(supervisor.equals(supervisor2));
        supervisor2.setName("Steve");
        assertFalse(supervisor.equals(supervisor2));
    }
}
