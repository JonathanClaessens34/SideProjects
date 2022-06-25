package be.pxl.researchproject.request;

import be.pxl.researchproject.api.request.CompanyRequest;
import be.pxl.researchproject.api.request.ContactPersonRequest;
import be.pxl.researchproject.builder.CompanyBuilder;
import be.pxl.researchproject.model.ContactPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactPersonRequestTest {
    private ContactPersonRequest contactPersonRequest;
    private ContactPerson contactPerson;

    @BeforeEach
    public void init() {
        contactPerson = new ContactPerson();
        contactPerson.setName("Tyrone");
        contactPerson.setEmail("Tyrone@gmail.com");
        contactPerson.setPhoneNumber("564566445");
        contactPerson.setTitle("Vice president");
        contactPerson.setFirstName("Steve");
        contactPersonRequest = new ContactPersonRequest(
                contactPerson.getTitle(),
                contactPerson.getName(),
                contactPerson.getFirstName(),
                contactPerson.getPhoneNumber(),
                contactPerson.getEmail()
        );
        contactPersonRequest.setEmail(contactPerson.getEmail());
        contactPersonRequest.setName(contactPerson.getName());
        contactPersonRequest.setPhoneNumber(contactPerson.getPhoneNumber());
        contactPersonRequest.setTitle(contactPerson.getTitle());
        contactPersonRequest.setFirstName(contactPerson.getFirstName());
    }

    @Test
    public void testGetters() {
        assertEquals(contactPersonRequest.getName(), contactPerson.getName());
        assertEquals(contactPersonRequest.getEmail(), contactPerson.getEmail());
        assertEquals(contactPersonRequest.getPhoneNumber(), contactPerson.getPhoneNumber());
        assertEquals(contactPersonRequest.getTitle(), contactPerson.getTitle());
        assertEquals(contactPersonRequest.getFirstName(), contactPerson.getFirstName());
    }
}
