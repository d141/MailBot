package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        String csvFile = "";//Location of contacts.csv
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        ArrayList<String[]> contacts = new ArrayList<String[]>();

        try {

            br = new BufferedReader(new FileReader(csvFile));

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] contact = line.split(cvsSplitBy);
                contacts.add(contact);
                System.out.println(contact[0]);
            }

            int numContacts = contacts.size();
            System.out.println(numContacts);

            for (int i = 0; i < numContacts; i++) {
                //System.out.println(i);
                //System.out.println("here");
                // Recipient's email ID needs to be mentioned.
                String to = contacts.get(i)[0];//change accordingly
                System.out.println(to);
                // Sender's email ID needs to be mentioned
                String from = "";//change accordingly
                final String username = "";//change accordingly
                final String password = "";//change accordingly

                // Assuming you are sending email through relay.jangosmtp.net
                String host = "secure244.inmotionhosting.com";

                Properties props = new Properties();
                props.put("mail.smtp.localhost", "sales.logoknits.com");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.ssl.trust", "secure244.inmotionhosting.com");
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
                //    String company = contacts.get(i)[3];
                    String subject = "Custom Knit Mascot Blankets";
                    // Set Subject: header field
                    message.setSubject(subject);

                    String message = "Hi " + contacts.get(i)[1]+",\n\n"

                    // Now set the actual message
                    message.setText(message);

                    message.setSentDate(new Date());

                    //    String dateFormat = "yyyy-MM-dd HH:mm:ss"; // you specify the format for your date
                    //    String formattedDate = new SimpleDateFormat(dateFormat).format(new Date());
                    //    message.addHeader("Date", formattedDate);

                    // Send message
                    Transport.send(message);

                    System.out.println("Sent message to "+ to);

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }

                TimeUnit.MINUTES.sleep(2);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Emails are dead");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Emails are dead");
        }





    }
}
