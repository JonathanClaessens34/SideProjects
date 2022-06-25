package be.pxl.researchproject.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntershipDescriptionTest {
    private InternshipDescription intershipDescription;

    private final String DESCRIPTIONASSIGNMENT = "Frontend", RESEARCHTHEME = "Development", CONDITIONS = "Qualified", COMMENTS = "Follow tyreese@gmail.com"
            , ENVIRONMENT = "Vue", ENVIRONMENTDESCRIPTION = "Vue, Vuex", PREFERREDSEPCIALIZATION = "Application Development", INTRODUCTORYACTIVITIES = "Testing", INTERNSHIPPERIOD = "Semester 1 (oktober - januari ), Semester 2 (februari - juni)", TITLEINTERSHIPASSIGNMENT = "FRONTEND Coding", SELECTIONOFSTUDENTSOPTIONAL = "Patrick";
    private final int NUMBEROFDESIREDINTERNS = 2;

    @BeforeEach
    public void init() {
        intershipDescription = new InternshipDescription();
        intershipDescription.setDescriptionAssignment(DESCRIPTIONASSIGNMENT);
        intershipDescription.setResearchTheme(RESEARCHTHEME);
        intershipDescription.setConditions(CONDITIONS);
        intershipDescription.setComments(COMMENTS);
        intershipDescription.setEnvironmentDescription(ENVIRONMENTDESCRIPTION);
        intershipDescription.setEnvironment(ENVIRONMENT);
        intershipDescription.setPreferredSpecialization(PREFERREDSEPCIALIZATION);
        intershipDescription.setIntroductoryActivities(INTRODUCTORYACTIVITIES);
        intershipDescription.setInternshipPeriod(INTERNSHIPPERIOD);
        intershipDescription.setTitleInternshipAssignment(TITLEINTERSHIPASSIGNMENT);
        intershipDescription.setSelectionOfStudentsOptional(SELECTIONOFSTUDENTSOPTIONAL);
        intershipDescription.setNumberOfDesiredInterns(NUMBEROFDESIREDINTERNS);
    }

    @Test
    public void testSetters() {
        assertEquals(intershipDescription.getDescriptionAssignment(), DESCRIPTIONASSIGNMENT);
        assertEquals(intershipDescription.getResearchTheme(), RESEARCHTHEME);
        assertEquals(intershipDescription.getConditions(), CONDITIONS);
        assertEquals(intershipDescription.getComments(), COMMENTS);
        assertEquals(intershipDescription.getEnvironmentDescription(), ENVIRONMENTDESCRIPTION);
        assertEquals(intershipDescription.getEnvironment(), ENVIRONMENT);
        assertEquals(intershipDescription.getPreferredSpecialization(), PREFERREDSEPCIALIZATION);
        assertEquals(intershipDescription.getIntroductoryActivities(), INTRODUCTORYACTIVITIES);
        assertEquals(intershipDescription.getInternshipPeriod(), INTERNSHIPPERIOD);
        assertEquals(intershipDescription.getTitleInternshipAssignment(), TITLEINTERSHIPASSIGNMENT);
        assertEquals(intershipDescription.getSelectionOfStudentsOptional(), SELECTIONOFSTUDENTSOPTIONAL);
        assertEquals(intershipDescription.getNumberOfDesiredInterns(), NUMBEROFDESIREDINTERNS);
    }

    @Test
    public void testEqualsSameCompany() {
        InternshipDescription contactPerson2 = intershipDescription;
        assertTrue(intershipDescription.equals(contactPerson2));
    }

    @Test
    public void testEqualsNullAndOtherClass() {
        String a = "";
        assertFalse(intershipDescription.equals(null));
        assertFalse(intershipDescription.equals(a));
    }

    @Test
    public void testEquals() {
        InternshipDescription intershipDescription2 = new InternshipDescription();
        intershipDescription2.setDescriptionAssignment(DESCRIPTIONASSIGNMENT);
        intershipDescription2.setResearchTheme(RESEARCHTHEME);
        intershipDescription2.setConditions(CONDITIONS);
        intershipDescription2.setComments(COMMENTS);
        intershipDescription2.setEnvironmentDescription(ENVIRONMENTDESCRIPTION);
        intershipDescription2.setEnvironment(ENVIRONMENT);
        intershipDescription2.setPreferredSpecialization(PREFERREDSEPCIALIZATION);
        intershipDescription2.setIntroductoryActivities(INTRODUCTORYACTIVITIES);
        intershipDescription2.setInternshipPeriod(INTERNSHIPPERIOD);
        intershipDescription2.setTitleInternshipAssignment(TITLEINTERSHIPASSIGNMENT);
        intershipDescription2.setSelectionOfStudentsOptional(SELECTIONOFSTUDENTSOPTIONAL);
        intershipDescription2.setNumberOfDesiredInterns(NUMBEROFDESIREDINTERNS);
        assertTrue(intershipDescription.equals(intershipDescription2));
        intershipDescription2.setResearchTheme("AI");
        assertFalse(intershipDescription.equals(intershipDescription2));
    }
}
