package be.pxl.researchproject.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ContactPersonTest {
    private ContactPerson contactperson;

    private final String TITLE= "Accountant";
    private final String NAME = "Tyreese Gibson", FIRSTNAME = "Tyreese", PHONENUMBER = "54656556", EMAIL = "tyreese@gmail.com";

    @BeforeEach
    public void init() {
        contactperson = new ContactPerson();
        contactperson.setTitle(TITLE);
        contactperson.setName(NAME);
        contactperson.setFirstName(FIRSTNAME);
        contactperson.setPhoneNumber(PHONENUMBER);
        contactperson.setEmail(EMAIL);
    }

    @Test
    public void testSetters() {
        assertEquals(contactperson.getTitle(), TITLE);
        assertEquals(contactperson.getName(), NAME);
        assertEquals(contactperson.getFirstName(), FIRSTNAME);
        assertEquals(contactperson.getPhoneNumber(), PHONENUMBER);
        assertEquals(contactperson.getEmail(), EMAIL);
    }

    @Test
    public void testEqualsSameCompany() {
        ContactPerson contactPerson2 = contactperson;
        assertTrue(contactperson.equals(contactPerson2));
    }

    @Test
    public void testEqualsNullAndOtherClass() {
        String a = "";
        assertFalse(contactperson.equals(null));
        assertFalse(contactperson.equals(a));
    }

    @Test
    public void testEquals() {
        ContactPerson contactperson2 = new ContactPerson();
        contactperson2.setTitle(TITLE);
        contactperson2.setName(NAME);
        contactperson2.setFirstName(FIRSTNAME);
        contactperson2.setPhoneNumber(PHONENUMBER);
        contactperson2.setEmail(EMAIL);
        assertTrue(contactperson.equals(contactperson2));
        contactperson2.setName("Steve");
        assertFalse(contactperson.equals(contactperson2));
    }
}
