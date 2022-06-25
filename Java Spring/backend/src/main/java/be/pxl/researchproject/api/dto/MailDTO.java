package be.pxl.researchproject.api.dto;

import be.pxl.researchproject.model.Mail;

import javax.mail.Address;

public class MailDTO {
    private String username, subject, message;
    private Address[] recipients;

    public MailDTO(Mail mail) {
        this.username = mail.getUsername();
        this.subject = mail.getSubject();
        this.recipients = mail.getRecipients();
        this.message = mail.getMessage();
    }

    public String getUsername() {
        return username;
    }

    public String getSubject() {
        return subject;
    }

    public Address[] getRecipients() {
        return recipients;
    }

    public String getMessage() {
        return message;
    }
}
