package be.pxl.researchproject.api.request;

import javax.mail.Address;

public class MailRequest {

    private String username;
    private String password;
    private String subject;
    private Address[] recipients;
    private String msg;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Address[] getRecipients() {
        return recipients;
    }

    public void setRecipients(Address[] recipients) {
        this.recipients = recipients;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
