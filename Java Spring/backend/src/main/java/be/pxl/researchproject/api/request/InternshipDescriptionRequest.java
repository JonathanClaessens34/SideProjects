package be.pxl.researchproject.api.request;

public class InternshipDescriptionRequest {

    private String descriptionAssignment, researchTheme, conditions;
    private String preferredSpecialization, environment, environmentDescription, selectionOfStudentsOptional,
            introductoryActivities, internship, titleInternshipAssignment, comments;
    private int numberOfDesiredInterns;

    public InternshipDescriptionRequest(String descriptionAssignment, String researchTheme, String conditions,
                                        String preferredSpecialization, String environment, String introductoryActivities,
                                        String internship, String titleInternshipAssignment, String comments,
                                        int numberOfDesiredInterns, String environmentDescription, String selectionOfStudentsOptional) {
        this.descriptionAssignment = descriptionAssignment;
        this.researchTheme = researchTheme;
        this.conditions = conditions;
        this.preferredSpecialization = preferredSpecialization;
        this.environment = environment;
        this.introductoryActivities = introductoryActivities;
        this.internship = internship;
        this.titleInternshipAssignment = titleInternshipAssignment;
        this.comments = comments;
        this.numberOfDesiredInterns = numberOfDesiredInterns;
        this.environmentDescription = environmentDescription;
        this.selectionOfStudentsOptional = selectionOfStudentsOptional;
    }

    public String getEnvironmentDescription() {
        return environmentDescription;
    }

    public void setEnvironmentDescription(String environmentDescription) {
        this.environmentDescription = environmentDescription;
    }

    public String getSelectionOfStudentsOptional() {
        return selectionOfStudentsOptional;
    }

    public void setSelectionOfStudentsOptional(String selectionOfStudentsOptional) {
        this.selectionOfStudentsOptional = selectionOfStudentsOptional;
    }

    public String getDescriptionAssignment() {
        return descriptionAssignment;
    }

    public void setDescriptionAssignment(String descriptionAssignment) {
        this.descriptionAssignment = descriptionAssignment;
    }

    public String getResearchTheme() {
        return researchTheme;
    }

    public void setResearchTheme(String researchTheme) {
        this.researchTheme = researchTheme;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getPreferredSpecialization() {
        return preferredSpecialization;
    }

    public void setPreferredSpecialization(String preferredSpecialization) {
        this.preferredSpecialization = preferredSpecialization;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getIntroductoryActivities() {
        return introductoryActivities;
    }

    public void setIntroductoryActivities(String introductoryActivities) {
        this.introductoryActivities = introductoryActivities;
    }

    public String getInternship() {
        return internship;
    }

    public void setInternship(String internship) {
        this.internship = internship;
    }

    public String getTitleInternshipAssignment() {
        return titleInternshipAssignment;
    }

    public void setTitleInternshipAssignment(String titleInternshipAssignment) {
        this.titleInternshipAssignment = titleInternshipAssignment;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getNumberOfDesiredInterns() {
        return numberOfDesiredInterns;
    }

    public void setNumberOfDesiredInterns(int numberOfDesiredInterns) {
        this.numberOfDesiredInterns = numberOfDesiredInterns;
    }
}
