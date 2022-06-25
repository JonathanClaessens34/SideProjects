package be.pxl.researchproject.model;

import javax.mail.Address;
import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Mail")
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(length = 1000, nullable = false)
    private String username;
    @Column(nullable = true)
    private String subject, message;
    private Address[] recipients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRecipients(Address[] recipients) {
        this.recipients = recipients;
    }

    public Address[] getRecipients() {
        return recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
