package be.pxl.researchproject.model;

import be.pxl.researchproject.builder.CompanyBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class InternshipAssignmentTest {
    private InternshipAssignment internshipAssignment;

    private final String TITLE = "Frontend";
    private final Company COMPANY = CompanyBuilder.aCompany().build();
    private final ContactPerson CONTACTPERSON = new ContactPerson();
    private final Supervisor SUPERVISOR = new Supervisor();
    private final InternshipDescription INTERNSHIPDESCRIPTION = new InternshipDescription();
    private final Reviewer REVIEWER = new Reviewer();
    private final StatusInternshipAssignment STATUS = StatusInternshipAssignment.Nieuw;
    private final String TIMESTAMP = "";

    @BeforeEach
    public void init() {
        internshipAssignment = new InternshipAssignment();
        internshipAssignment.setTitle(TITLE);
        internshipAssignment.setCompany(COMPANY);
        internshipAssignment.setContactPerson(CONTACTPERSON);
        internshipAssignment.setSupervisor(SUPERVISOR);
        internshipAssignment.setInternshipDescription(INTERNSHIPDESCRIPTION);
        internshipAssignment.setReviewer(REVIEWER);
        internshipAssignment.setStatus(STATUS);
        internshipAssignment.setTimestamp(TIMESTAMP);
    }

    @Test
    public void testSetters() {
        assertEquals(internshipAssignment.getTitle(), TITLE);
        assertEquals(internshipAssignment.getCompany(), COMPANY);
        assertEquals(internshipAssignment.getContactPerson(), CONTACTPERSON);
        assertEquals(internshipAssignment.getSupervisor(), SUPERVISOR);
        assertEquals(internshipAssignment.getInternshipDescription(), INTERNSHIPDESCRIPTION);
        assertEquals(internshipAssignment.getReviewer(), REVIEWER);
        assertEquals(internshipAssignment.getStatus(), STATUS);
        assertEquals(internshipAssignment.getTimestamp(), TIMESTAMP);
    }

    @Test
    public void testEqualsSameCompany() {
        InternshipAssignment contactPerson2 = internshipAssignment;
        assertTrue(internshipAssignment.equals(contactPerson2));
    }

    @Test
    public void testEqualsNullAndOtherClass() {
        String a = "";
        assertFalse(internshipAssignment.equals(null));
        assertFalse(internshipAssignment.equals(a));
    }

    @Test
    public void testEquals() {
        InternshipAssignment internshipAssignment2 = new InternshipAssignment();
        internshipAssignment2.setTitle(TITLE);
        internshipAssignment2.setCompany(COMPANY);
        internshipAssignment2.setContactPerson(CONTACTPERSON);
        internshipAssignment2.setSupervisor(SUPERVISOR);
        internshipAssignment2.setInternshipDescription(INTERNSHIPDESCRIPTION);
        internshipAssignment2.setReviewer(REVIEWER);
        internshipAssignment2.setStatus(STATUS);
        internshipAssignment2.setTimestamp(TIMESTAMP);
        assertTrue(this.internshipAssignment.equals(internshipAssignment2));
        internshipAssignment2.setStatus(StatusInternshipAssignment.Bevestigd);
        assertFalse(this.internshipAssignment.equals(internshipAssignment2));
    }
}
