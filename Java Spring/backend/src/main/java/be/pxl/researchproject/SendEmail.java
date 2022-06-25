package be.pxl.researchproject;

import be.pxl.researchproject.api.request.MailRequest;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) {
//        final String username = "tyrone987651056@gmail.com";
//        final String password = "bpzljlwurpuqrqhf";
//        final String subject = "Test REST 01";
//        final String recipients = "explosiefinterceptie@gmail.com";
//        final String msg = "Tupac is alive.";
//        sendEmail(username, password, subject, recipients, msg);
    }

    public static void sendEmail(MailRequest mailRequest) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");

        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");



        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailRequest.getUsername(), mailRequest.getPassword());
            }
        });

        try {

            Message message = new MimeMessage(session);
            
            Address[] recipientList = mailRequest.getRecipients();
            InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for (Address recipient : recipientList) {
                recipientAddress[counter] = new InternetAddress(recipient.toString());
                counter++;
            }
            message.setRecipients(Message.RecipientType.TO, recipientAddress);

            message.setFrom(new InternetAddress(mailRequest.getUsername()));
            message.setSubject(mailRequest.getSubject());

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(mailRequest.getMsg(), "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Message sent!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
