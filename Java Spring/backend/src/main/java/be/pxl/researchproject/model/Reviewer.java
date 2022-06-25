package be.pxl.researchproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="reviewer")
public class Reviewer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String firstName, lastName, mail, reviewCommentary;

    public Long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReviewCommentary() {
        return reviewCommentary;
    }

    public void setReviewCommentary(String reviewCommentary) {
        this.reviewCommentary = reviewCommentary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reviewer reviewer = (Reviewer) o;
        return Objects.equals(firstName, reviewer.firstName) && Objects.equals(lastName, reviewer.lastName) && Objects.equals(mail, reviewer.mail) && Objects.equals(reviewCommentary, reviewer.reviewCommentary);
    }
}
