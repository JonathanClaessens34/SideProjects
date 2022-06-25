package be.pxl.researchproject;

import be.pxl.researchproject.api.dto.MailDTO;
import be.pxl.researchproject.api.request.MailRequest;
import be.pxl.researchproject.model.Mail;
import com.sun.mail.pop3.POP3Store;

import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;

import static org.apache.logging.log4j.util.Strings.isNotBlank;


public class ReceiveEmail {


    public static ArrayList<MailDTO> receiveEmail(String pop3Host, String storeType, MailRequest mailRequest) {
        ArrayList<MailDTO> result = null;
        try {
            Properties properties = new Properties();
            properties.put("mail.pop3.host", pop3Host);
            properties.setProperty("mail.pop3.auth", "true");
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.smtp", "587");
            properties.put("mail.pop3.starttls.enable", "true");
            properties.setProperty("mail.pop3.ssl.enable", "true");
            properties.setProperty("mail.pop3s.ssl.trust", "*");
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailRequest.getUsername(), mailRequest.getPassword());
                }
            });

            POP3Store emailStore = (POP3Store) session.getStore(storeType);
            emailStore.connect(mailRequest.getUsername(), mailRequest.getPassword());

            Folder emailFolder = emailStore.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);

            Message[] messages = emailFolder.getMessages();
            ArrayList<Message> rightMessages = new ArrayList<>();
            for (int i = 0; i < messages.length; i++) {
                Message msg = messages[i];
//                Address[] fromAddress = msg.getFrom();
//                String from = fromAddress[0].toString();
//                String subject = msg.getSubject();
//                Address[] toList = msg.getRecipients(Message.RecipientType.TO);
//                Address[] ccList = msg.getRecipients(Message.RecipientType.CC);
//                String contentType = msg.getContentType();
                if (mailRequest.getSubject().equals(msg.getSubject())) {
                    rightMessages.add(msg);
                }
            }
//            private String username, subject, message;
//            private String[] recipients;
            /*ArrayList<MailDTO> mails = new ArrayList<>();
            for (Message message : rightMessages) {
                Mail mail = new Mail();
                mail.setMessage(message.getContent().toString());
                mail.setSubject(message.getSubject());
                mail.setRecipients(message.getRecipients(Message.RecipientType.TO));
            }*/
            result = (ArrayList<MailDTO>) rightMessages.stream().map(message -> {
                Mail mail = new Mail();
                try {
                    mail.setMessage(message.getContent().toString());
                    mail.setSubject(message.getSubject());
                    mail.setRecipients(message.getRecipients(Message.RecipientType.TO));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                return new MailDTO(mail);
            }).toList();

            emailFolder.close(false);
            emailStore.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return result;
    }



}
