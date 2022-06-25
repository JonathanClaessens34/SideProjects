package be.pxl.researchproject.request;

import be.pxl.researchproject.api.request.InternshipDescriptionRequest;
import be.pxl.researchproject.model.InternshipDescription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InternshipDescriptionRequestTest {
    private InternshipDescriptionRequest internshipDescriptionRequest;
    private InternshipDescription internshipDescription;

    @BeforeEach
    public void init() {
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
        internshipDescriptionRequest = new InternshipDescriptionRequest(
                internshipDescription.getDescriptionAssignment(),
                internshipDescription.getResearchTheme(),
                internshipDescription.getConditions(),
                internshipDescription.getPreferredSpecialization(),
                internshipDescription.getEnvironment(),
                internshipDescription.getIntroductoryActivities(),
                internshipDescription.getInternshipPeriod(),
                internshipDescription.getTitleInternshipAssignment(),
                internshipDescription.getComments(),
                internshipDescription.getNumberOfDesiredInterns(),
                internshipDescription.getEnvironmentDescription(),
                internshipDescription.getSelectionOfStudentsOptional()
        );
        internshipDescriptionRequest.setDescriptionAssignment(internshipDescription.getDescriptionAssignment());
        internshipDescriptionRequest.setResearchTheme(internshipDescription.getResearchTheme());
        internshipDescriptionRequest.setConditions(internshipDescription.getConditions());
        internshipDescriptionRequest.setPreferredSpecialization(internshipDescription.getPreferredSpecialization());
        internshipDescriptionRequest.setEnvironment(internshipDescription.getEnvironment());
        internshipDescriptionRequest.setIntroductoryActivities(internshipDescription.getIntroductoryActivities());
        internshipDescriptionRequest.setTitleInternshipAssignment(internshipDescription.getTitleInternshipAssignment());
        internshipDescriptionRequest.setComments(internshipDescription.getComments());
        internshipDescriptionRequest.setNumberOfDesiredInterns(internshipDescription.getNumberOfDesiredInterns());
        internshipDescriptionRequest.setEnvironmentDescription(internshipDescription.getEnvironmentDescription());
        internshipDescriptionRequest.setSelectionOfStudentsOptional(internshipDescription.getSelectionOfStudentsOptional());
    }

    @Test
    public void testGetters() {
        assertEquals(internshipDescriptionRequest.getDescriptionAssignment(), internshipDescription.getDescriptionAssignment());
        assertEquals(internshipDescriptionRequest.getResearchTheme(), internshipDescription.getResearchTheme());
        assertEquals(internshipDescriptionRequest.getConditions(), internshipDescription.getConditions());
        assertEquals(internshipDescriptionRequest.getPreferredSpecialization(), internshipDescription.getPreferredSpecialization());
        assertEquals(internshipDescriptionRequest.getEnvironmentDescription(), internshipDescription.getEnvironmentDescription());
        assertEquals(internshipDescriptionRequest.getEnvironment(), internshipDescription.getEnvironment());
        assertEquals(internshipDescriptionRequest.getIntroductoryActivities(), internshipDescription.getIntroductoryActivities());
        assertEquals(internshipDescriptionRequest.getInternship(), internshipDescription.getInternshipPeriod());
        assertEquals(internshipDescriptionRequest.getTitleInternshipAssignment(), internshipDescription.getTitleInternshipAssignment());
        assertEquals(internshipDescriptionRequest.getComments(), internshipDescription.getComments());
        assertEquals(internshipDescriptionRequest.getNumberOfDesiredInterns(), internshipDescription.getNumberOfDesiredInterns());
        assertEquals(internshipDescriptionRequest.getSelectionOfStudentsOptional(), internshipDescription.getSelectionOfStudentsOptional());

    }
}
