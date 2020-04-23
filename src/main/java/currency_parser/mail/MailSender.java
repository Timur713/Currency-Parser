package currency_parser.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailSender {

    public static void sendMail(String recipient) throws MessagingException {
        System.out.println("Prepare to sent email");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        final String myAcc = "tisanbirdin@gmail.com";
        final String password = "timur5056";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAcc, password);
            }
        });

        Message message = prepareMessage(session, myAcc, recipient);

        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAcc, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAcc));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("First sending");
            message.setContent("<h3 style=\"color: red\">Clash</h3> <h3 style=\"color: blue\">Royale</h3> <h3 style=\"color: green\">forever</h3>", "text/html");

            return message;

        } catch (MessagingException e) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
