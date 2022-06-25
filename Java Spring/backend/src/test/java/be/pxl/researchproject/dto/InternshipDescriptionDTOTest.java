package be.pxl.researchproject.dto;

import be.pxl.researchproject.api.dto.ContactPersonDTO;
import be.pxl.researchproject.api.dto.InternshipAssignmentDTO;
import be.pxl.researchproject.api.dto.InternshipDescriptionDTO;
import be.pxl.researchproject.model.ContactPerson;
import be.pxl.researchproject.model.InternshipDescription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InternshipDescriptionDTOTest {
    private InternshipDescriptionDTO internshipAssignmentDTO;

    @BeforeEach
    public void init() {
        InternshipDescription internshipDescription = new InternshipDescription();
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
        this.internshipAssignmentDTO = new InternshipDescriptionDTO(internshipDescription);
    }

    @Test
    public void testGetters() {
        assertEquals(internshipAssignmentDTO.getInternship(), "4/8/2001");
        assertEquals(internshipAssignmentDTO.getResearchTheme(), "Real stuff");
        assertEquals(internshipAssignmentDTO.getNumberOfDesiredInterns(), 2);
        assertEquals(internshipAssignmentDTO.getEnvironmentDescription(), "Vue");
        assertEquals(internshipAssignmentDTO.getTitleInternshipAssignment(), "Frontend");
        assertEquals(internshipAssignmentDTO.getEnvironment(), "Veux");
        assertEquals(internshipAssignmentDTO.getTitleInternshipAssignment(), "Frontend");
        assertEquals(internshipAssignmentDTO.getSelectionOfStudentsOptional(), "Tyrone");
        assertEquals(internshipAssignmentDTO.getIntroductoryActivities(), "Hacking");
        assertEquals(internshipAssignmentDTO.getComments(), "Follow");
        assertEquals(internshipAssignmentDTO.getPreferredSpecialization(), "Frontend");
        assertEquals(internshipAssignmentDTO.getRandvoorwaarden(), "Harsh");
    }
}
