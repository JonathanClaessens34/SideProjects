package be.pxl.researchproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="stageopdracht")
public class InternshipAssignment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    private Company company;
    @OneToOne(cascade = CascadeType.ALL)
    private ContactPerson contactPerson;
    @OneToOne(cascade = CascadeType.ALL)
    private Supervisor supervisor;
    @OneToOne(cascade = CascadeType.ALL)
    private InternshipDescription internshipDescription;
    @OneToOne(cascade = CascadeType.ALL)
    private Reviewer reviewer;
    @Enumerated(EnumType.STRING)
    private StatusInternshipAssignment status;
    private String timestamp;

    public Long getId() {
        return id;
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

    public InternshipDescription getInternshipDescription() {
        return internshipDescription;
    }

    public void setInternshipDescription(InternshipDescription internshipDescription) {
        this.internshipDescription = internshipDescription;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternshipAssignment that = (InternshipAssignment) o;
        return Objects.equals(title, that.title) && Objects.equals(company, that.company) && Objects.equals(contactPerson, that.contactPerson) && Objects.equals(supervisor, that.supervisor) && Objects.equals(internshipDescription, that.internshipDescription) && Objects.equals(reviewer, that.reviewer) && status == that.status && Objects.equals(timestamp, that.timestamp);
    }
}
