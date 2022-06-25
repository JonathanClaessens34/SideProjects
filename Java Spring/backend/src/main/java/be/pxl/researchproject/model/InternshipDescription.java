package be.pxl.researchproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="stageomschrijving")
public class InternshipDescription {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(columnDefinition="LONGTEXT")
    private String descriptionAssignment;
    @Column(columnDefinition="LONGTEXT")
    private String researchTheme;
    @Column(columnDefinition="LONGTEXT")
    private String conditions, comments, environment, environmentDescription;
    private String preferredSpecialization, introductoryActivities, internshipPeriod, titleInternshipAssignment, selectionOfStudentsOptional;
    @Column(nullable = true)
    private int numberOfDesiredInterns;

    public Long getId() {
        return id;
    }

    public String getSelectionOfStudentsOptional() {
        return selectionOfStudentsOptional;
    }

    public void setSelectionOfStudentsOptional(String selectieStudentionOptioneel) {
        this.selectionOfStudentsOptional = selectieStudentionOptioneel;
    }

    public String getPreferredSpecialization() {
        return preferredSpecialization;
    }

    public void setPreferredSpecialization(String voorkeurAfstudeerrichting) {
        this.preferredSpecialization = voorkeurAfstudeerrichting;
    }

    public String getDescriptionAssignment() {
        return descriptionAssignment;
    }

    public void setDescriptionAssignment(String omschrijvingOpdracht) {
        this.descriptionAssignment = omschrijvingOpdracht;
    }

    public String getEnvironmentDescription() {
        return environmentDescription;
    }

    public void setEnvironmentDescription(String omgevingBeschrijving) {
        this.environmentDescription = omgevingBeschrijving;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String omgeving) {
        this.environment = omgeving;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String randvoorwaarden) {
        this.conditions = randvoorwaarden;
    }

    public String getResearchTheme() {
        return researchTheme;
    }

    public void setResearchTheme(String onderzoeksthema) {
        this.researchTheme = onderzoeksthema;
    }

    public String getIntroductoryActivities() {
        return introductoryActivities;
    }

    public void setIntroductoryActivities(String inleidendeActiviteiten) {
        this.introductoryActivities = inleidendeActiviteiten;
    }

    public String getInternshipPeriod() {
        return internshipPeriod;
    }

    public void setInternshipPeriod(String stageperiode) {
        this.internshipPeriod = stageperiode;
    }

    public String getTitleInternshipAssignment() {
        return titleInternshipAssignment;
    }

    public void setTitleInternshipAssignment(String titelStageopdracht) {
        this.titleInternshipAssignment = titelStageopdracht;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String opmerkingen) {
        this.comments = opmerkingen;
    }

    public int getNumberOfDesiredInterns() {
        return numberOfDesiredInterns;
    }

    public void setNumberOfDesiredInterns(int aantalGewensteStagiairs) {
        this.numberOfDesiredInterns = aantalGewensteStagiairs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternshipDescription that = (InternshipDescription) o;
        return numberOfDesiredInterns == that.numberOfDesiredInterns && Objects.equals(descriptionAssignment, that.descriptionAssignment) && Objects.equals(researchTheme, that.researchTheme) && Objects.equals(conditions, that.conditions) && Objects.equals(comments, that.comments) && Objects.equals(environment, that.environment) && Objects.equals(environmentDescription, that.environmentDescription) && Objects.equals(preferredSpecialization, that.preferredSpecialization) && Objects.equals(introductoryActivities, that.introductoryActivities) && Objects.equals(internshipPeriod, that.internshipPeriod) && Objects.equals(titleInternshipAssignment, that.titleInternshipAssignment) && Objects.equals(selectionOfStudentsOptional, that.selectionOfStudentsOptional);
    }
}
