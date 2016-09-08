/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.dinnermenu2;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;


/**
 *
 * @author ajswe
 */
public class Email {
    private static Component popup;
    private final String attachment_path;
    private String to;
    private final String from;
    private final String username;
    private final String password;
    private final String subject;
    private final String body;
    private final String host;
    private final Settings settings;
    private final String shopping_list;

    public Email(Settings settings, String shopping_list) {
        this.settings = settings;
        this.shopping_list = shopping_list;
        attachment_path = "shopping_list.txt";
        to = "";
        for(int i = 0; i < settings.get_emails().size()-1; i++) {
            to = to + settings.get_emails().get(i) + ",";
        }
        to = to + settings.get_emails().get(settings.get_emails().size()-1);
        from = "menucreator713@gmail.com";
        username = "menucreator713";
        password = "5853504650";
        subject = "Weekly Menu";
        body = shopping_list;
        host = "smtp.gmail.com";
    }
    
    public void create_shopping_list_file() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(attachment_path, "UTF-8");
        writer.println(shopping_list);
        writer.close();
    }

    public void send_email() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            
            // Set Subject: header field
            message.setSubject(subject);

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText(body);

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = attachment_path;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            JOptionPane.showMessageDialog(popup, "Email sent!");

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(popup, "Unable to send email!\n" + e.getMessage());
            //throw new RuntimeException(e);
        }
    }
}
