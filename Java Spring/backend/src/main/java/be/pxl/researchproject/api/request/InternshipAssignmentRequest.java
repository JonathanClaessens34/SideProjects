package be.pxl.researchproject.api.request;

import be.pxl.researchproject.model.*;

public class InternshipAssignmentRequest {
    private String title;
    private Company company;
    private ContactPerson contactPerson;
    private Supervisor supervisor;
    private StatusInternshipAssignment status;
    private String timestamp;
    private Reviewer reviewer;
    private InternshipDescription internshipDescription;

    public InternshipAssignmentRequest(String title, Company company, ContactPerson contactPerson,
                                       Supervisor supervisor, StatusInternshipAssignment status, String timestamp, Reviewer reviewer, InternshipDescription internshipDescription) {
        this.title = title;
        this.company = company;
        this.contactPerson = contactPerson;
        this.supervisor = supervisor;
        this.status = status;
        this.timestamp = timestamp;
        this.reviewer = reviewer;
        this.internshipDescription = internshipDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public StatusInternshipAssignment getStatus() {
        return status;
    }

    public void setStatus(StatusInternshipAssignment status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public InternshipDescription getInternshipDescription() {
        return internshipDescription;
    }

    public void setInternshipDescription(InternshipDescription internshipDescription) {
        this.internshipDescription = internshipDescription;
    }
}
