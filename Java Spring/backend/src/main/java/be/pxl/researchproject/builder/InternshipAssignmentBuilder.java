package be.pxl.researchproject.builder;

import be.pxl.researchproject.model.*;
import ch.qos.logback.core.status.Status;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.management.Descriptor;
import java.sql.Timestamp;

public class InternshipAssignmentBuilder {
    private String Title;
    private Company Company;
    private be.pxl.researchproject.model.ContactPerson ContactPerson;
    private be.pxl.researchproject.model.Supervisor Supervisor;
    private StatusInternshipAssignment Status;
    private String Timestamp;
    private Reviewer Reviewer;
    private InternshipDescription Description;

    private InternshipAssignmentBuilder() {}

    public static InternshipAssignmentBuilder aInternshipAssignment() {
        return new InternshipAssignmentBuilder();
    }

    public InternshipAssignmentBuilder withTitle(String title) {
        this.Title = title;
        return this;
    }

    public InternshipAssignmentBuilder withCompany(Company company) {
        this.Company = company;
        return this;
    }

    public InternshipAssignmentBuilder withContactPerson(ContactPerson contactPerson) {
        this.ContactPerson = contactPerson;
        return this;
    }

    public InternshipAssignmentBuilder withSupervisor(Supervisor supervisor) {
        this.Supervisor = supervisor;
        return this;
    }

    public InternshipAssignmentBuilder withStatus(StatusInternshipAssignment status) {
        this.Status = status;
        return this;
    }

    public InternshipAssignmentBuilder withTimestamp(String timestamp) {
        this.Timestamp = timestamp;
        return this;
    }

    public InternshipAssignmentBuilder withReviewer(Reviewer reviewer) {
        this.Reviewer = reviewer;
        return this;
    }

    public InternshipAssignmentBuilder withDescription(InternshipDescription description) {
        this.Description = description;
        return this;
    }

    public InternshipAssignment build() {
        InternshipAssignment internshipAssignment = new InternshipAssignment();
        internshipAssignment.setTitle(Title);
        internshipAssignment.setCompany(Company);
        internshipAssignment.setContactPerson(ContactPerson);
        internshipAssignment.setSupervisor(Supervisor);
        internshipAssignment.setStatus(Status);
        internshipAssignment.setTimestamp(Timestamp);
        internshipAssignment.setReviewer(Reviewer);
        internshipAssignment.setInternshipDescription(Description);
        return internshipAssignment;

    }
}
