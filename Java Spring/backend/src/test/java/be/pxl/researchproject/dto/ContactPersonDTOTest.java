package be.pxl.researchproject.dto;

import be.pxl.researchproject.api.dto.ContactPersonDTO;
import be.pxl.researchproject.model.ContactPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactPersonDTOTest {
    private ContactPersonDTO contactPerson;

    @BeforeEach
    public void init() {
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setName("Tyrone");
        contactPerson.setEmail("Tyrone@gmail.com");
        contactPerson.setPhoneNumber("564566445");
        contactPerson.setTitle("Vice president");
        contactPerson.setFirstName("Steve");
        this.contactPerson = new ContactPersonDTO(contactPerson);
    }

    @Test
    public void testGetters() {
        assertEquals(contactPerson.getEmail(), "Tyrone@gmail.com");
        assertEquals(contactPerson.getName(), "Tyrone");
        assertEquals(contactPerson.getPhoneNumber(), "564566445");
        assertEquals(contactPerson.getTitle(), "Vice president");
        assertEquals(contactPerson.getFirstName(), "Steve");
    }
}
