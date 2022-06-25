package be.pxl.researchproject.api.dto;

import be.pxl.researchproject.model.InternshipDescription;

public class InternshipDescriptionDTO {
    private String descriptionAssignment, researchTheme, randvoorwaarden;
    private String preferredSpecialization, environment, environmentDescription, selectionOfStudentsOptional,
            introductoryActivities, internship, titleInternshipAssignment, comments;
    private int numberOfDesiredInterns;

    public InternshipDescriptionDTO(InternshipDescription internshipDescription) {
        this.descriptionAssignment = internshipDescription.getDescriptionAssignment();
        this.researchTheme = internshipDescription.getResearchTheme();
        this.randvoorwaarden = internshipDescription.getConditions();
        this.preferredSpecialization = internshipDescription.getPreferredSpecialization();
        this.environment = internshipDescription.getEnvironment();
        this.introductoryActivities = internshipDescription.getIntroductoryActivities();
        this.internship = internshipDescription.getInternshipPeriod();
        this.titleInternshipAssignment = internshipDescription.getTitleInternshipAssignment();
        this.comments = internshipDescription.getComments();
        this.numberOfDesiredInterns = internshipDescription.getNumberOfDesiredInterns();
        this.environmentDescription = internshipDescription.getEnvironmentDescription();
        this.selectionOfStudentsOptional = internshipDescription.getSelectionOfStudentsOptional();
    }

    public String getEnvironmentDescription() {
        return environmentDescription;
    }

    public String getSelectionOfStudentsOptional() {
        return selectionOfStudentsOptional;
    }

    public String getDescriptionAssignment() {
        return descriptionAssignment;
    }

    public String getResearchTheme() {
        return researchTheme;
    }

    public String getRandvoorwaarden() {
        return randvoorwaarden;
    }

    public String getPreferredSpecialization() {
        return preferredSpecialization;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getIntroductoryActivities() {
        return introductoryActivities;
    }

    public String getInternship() {
        return internship;
    }

    public String getTitleInternshipAssignment() {
        return titleInternshipAssignment;
    }

    public String getComments() {
        return comments;
    }

    public int getNumberOfDesiredInterns() {
        return numberOfDesiredInterns;
    }
}
