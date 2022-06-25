package be.pxl.researchproject.api.dto;

import be.pxl.researchproject.model.*;

public class InternshipAssignmentDTO {
    private long id;
    private String title;
    private Company company;
    private ContactPerson contactPerson;
    private Supervisor supervisor;
    private StatusInternshipAssignment status;
    private String description;
    private String timestamp;
    private Student student;

    public InternshipAssignmentDTO(InternshipAssignment internshipAssignment) {
        this.id = internshipAssignment.getId();
        this.title = internshipAssignment.getInternshipDescription().getTitleInternshipAssignment();
        if (this.title == null) {
            this.title = "-/-";
        }
        this.company = internshipAssignment.getCompany();
        this.contactPerson = internshipAssignment.getContactPerson();
        this.supervisor = internshipAssignment.getSupervisor();
        this.status = internshipAssignment.getStatus();
        this.description = internshipAssignment.getInternshipDescription().getDescriptionAssignment();
        this.timestamp = internshipAssignment.getTimestamp();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
