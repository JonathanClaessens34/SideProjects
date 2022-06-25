package be.pxl.researchproject.dto;

import be.pxl.researchproject.api.dto.InternshipAssignmentDTO;
import be.pxl.researchproject.builder.CompanyBuilder;
import be.pxl.researchproject.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InternshipAssignmentDTOTest {
    private InternshipAssignmentDTO internshipAssignmentDTO;
    private String title;
    private Company company;
    private ContactPerson contactPerson;
    private Supervisor supervisor;
    private StatusInternshipAssignment status;
    private InternshipDescription internshipDescription;
    private Reviewer reviewer;
    private String description;
    private String timestamp;

    private final String titleSupervisor = "Vice president", name = "Smith", firstName = "Tyrone", phoneNumber = "56564412", email ="Tyrone@gmail.com";
    private final String lastName = "Michels", mail = "Tyrone@gmail.com", reviewCommentary = "= Seems good!";

    @BeforeEach
    public void init() {
        Company company = CompanyBuilder.aCompany().build();
        this.company = company;
        this.title = "Cool development";

        contactPerson = new ContactPerson();
        contactPerson.setName("Tyrone");
        contactPerson.setEmail("Tyrone@gmail.com");
        contactPerson.setPhoneNumber("564566445");
        contactPerson.setTitle("Vice president");
        contactPerson.setFirstName("Steve");

        supervisor = new Supervisor();
        supervisor.setTitle(titleSupervisor);
        supervisor.setName(name);
        supervisor.setFirstName(firstName);
        supervisor.setPhoneNumber(phoneNumber);
        supervisor.setEmail(email);

        this.status = StatusInternshipAssignment.Nieuw;
        this.description = "Vue";
        this.timestamp = "9/4/2022";

        reviewer = new Reviewer();
        reviewer.setFirstName(firstName);
        reviewer.setLastName(lastName);
        reviewer.setMail(mail);
        reviewer.setReviewCommentary(reviewCommentary);

        internshipDescription = new InternshipDescription();
        internshipDescription.setInternshipPeriod("4/8/2001");
        internshipDescription.setResearchTheme("Real stuff");
        internshipDescription.setNumberOfDesiredInterns(2);
        internshipDescription.setEnvironmentDescription("Program");
        internshipDescription.setTitleInternshipAssignment("Frontend vue");
        internshipDescription.setEnvironment("Veux");
        internshipDescription.setEnvironmentDescription("Vue");
        internshipDescription.setTitleInternshipAssignment("Frontend");
        internshipDescription.setSelectionOfStudentsOptional("Tyrone");
        internshipDescription.setIntroductoryActivities("Hacking");
        internshipDescription.setComments("Follow");
        internshipDescription.setConditions("Harsh");
        internshipDescription.setPreferredSpecialization("Frontend");

        InternshipAssignment internshipAssignment = new InternshipAssignment();
        internshipAssignment.setStatus(status);
        internshipAssignment.setInternshipDescription(internshipDescription);
        internshipAssignment.setTimestamp(timestamp);
        internshipAssignment.setReviewer(reviewer);
        internshipAssignment.setSupervisor(supervisor);
        internshipAssignment.setCompany(company);
        internshipAssignment.setContactPerson(contactPerson);
        internshipAssignment.setTitle(title);

        this.internshipAssignmentDTO = new InternshipAssignmentDTO(internshipAssignment);
    }

    @Test
    public void testGetters() {
        assertEquals(internshipAssignmentDTO.getTitle(), title);
        assertEquals(internshipAssignmentDTO.getCompany(), company);
        assertEquals(internshipAssignmentDTO.getContactPerson(), contactPerson);
        assertEquals(internshipAssignmentDTO.getDescription(), description);
        assertEquals(internshipAssignmentDTO.getStatus(), status);
        assertEquals(internshipAssignmentDTO.getSupervisor(), supervisor);
        assertEquals(internshipAssignmentDTO.getTimestamp(), timestamp);
    }
}
