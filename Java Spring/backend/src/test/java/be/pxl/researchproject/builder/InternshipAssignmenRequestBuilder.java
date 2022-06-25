package be.pxl.researchproject.builder;

import be.pxl.researchproject.api.dto.InternshipAssignmentDTO;
import be.pxl.researchproject.model.*;

public class InternshipAssignmenRequestBuilder {
    private final InternshipDescription INTERNSHIPDESCRIPTION = new InternshipDescription();
    private final Reviewer REVIEWER = new Reviewer();
    private final String TIMESTAMP = ""; //7/5/2021 11:56:12
    private final StatusInternshipAssignment STATUSINTERSHIPASSIGNMENT = StatusInternshipAssignment.Nieuw;
    private final Supervisor SUPERVISOR = new Supervisor();
    private final ContactPerson CONTACTPERSON = new ContactPerson();
    private final Company COMPANY = new Company();
    private final String TITLE = "";
    private String title = TITLE;
    private Company company = COMPANY;
    private ContactPerson contactPerson = CONTACTPERSON;
    private Supervisor supervisor = SUPERVISOR;
    private StatusInternshipAssignment status = STATUSINTERSHIPASSIGNMENT;
    private String timestamp = TIMESTAMP;
    private Reviewer reviewer = REVIEWER;
    private InternshipDescription internshipDescription = INTERNSHIPDESCRIPTION;

    private InternshipAssignmenRequestBuilder() {
    }

    public static InternshipAssignmenRequestBuilder anIntershipAssigmentRequest() {return new InternshipAssignmenRequestBuilder();}

    public InternshipAssignmenRequestBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public InternshipAssignmenRequestBuilder setCompany(Company company) {
        this.company = company;
        return this;
    }

    public InternshipAssignmenRequestBuilder setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public InternshipAssignmenRequestBuilder setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
        return this;
    }

    public InternshipAssignmenRequestBuilder setStatus(StatusInternshipAssignment status) {
        this.status = status;
        return this;
    }

    public InternshipAssignmenRequestBuilder setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public InternshipAssignmenRequestBuilder setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
        return this;
    }

    public InternshipAssignmenRequestBuilder setInternshipDescription(InternshipDescription internshipDescription) {
        this.internshipDescription = internshipDescription;
        return this;
    }

    public InternshipAssignmentDTO build() {
        InternshipAssignment internshipAssignment = new InternshipAssignment();
        internshipAssignment.setInternshipDescription(internshipDescription);
        internshipAssignment.setReviewer(reviewer);
        internshipAssignment.setSupervisor(supervisor);
        internshipAssignment.setCompany(company);
        internshipAssignment.setContactPerson(contactPerson);
        internshipAssignment.setStatus(status);
        internshipAssignment.setTitle(title);
        internshipAssignment.setTimestamp(timestamp);
        return new InternshipAssignmentDTO(internshipAssignment);
    }
}
