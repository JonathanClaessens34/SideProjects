package be.pxl.researchproject.request;

import be.pxl.researchproject.api.request.MailRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailRequestTest {
    private MailRequest mailRequest;
    private String username = "Tyrone";
    private String password = "password1234";
    private String subject = "Econ";
    //private Address[] recipients = new InternetAddress;
    private String msg = "Hello world!";

    @BeforeEach
    public void init() {
        mailRequest = new MailRequest();
        mailRequest.setUsername(username);
        mailRequest.setPassword(password);
        mailRequest.setSubject(subject);
        //mailRequest.setRecipients(recipients);
        mailRequest.setMsg(msg);
    }

    @Test
    public void testGetters() {
        assertEquals(mailRequest.getUsername(), username);
        assertEquals(mailRequest.getMsg(), msg);
        assertEquals(mailRequest.getPassword(), password);
        assertEquals(mailRequest.getSubject(), subject);
        //assertEquals(mailRequest.getRecipients(), recipients);
    }
}
