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

        String csvFile = "/Users/davevananda/KMS Dropbox/Dave Van Anda/Archives/Daves Stuff/Contacts-Contact.txt";
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
                String from = "eric@sales.logoknits.com";//change accordingly
                final String username = "eric@sales.logoknits.com";//change accordingly
                final String password = "Logo12!@";//change accordingly

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

                   String fdMessage = "Hi " + contacts.get(i)[1]+",\n\n" + "My name is Shannon Kirch.  I'm with Logo Knits where we design and manufacture custom knit blankets." +
                            "  Our blankets are in firehouses all across the country, so I'm reaching out to make sure that your department has the chance to check them out too.\n\n"
                            + "Some key facts...\n\n"+ "-100% Made in the USA\n-Custom Sample...NO CHARGE\n-Low minimum (12)\n-Can be personalized with names, ranks, etc.\n"
                            + "-Two sizes available (Bed and Stadium)\n\n"
                            + "If you're interested I'm happy to send over a pdf with some pictures and more information.\n\n" +
                            "Thanks for your time and I hope to hear from you,\n\n" +
                            "Shannon Kirch\n" +
                            "Logo Knits\n" +
                            "42A Cindy Lane, Ocean NJ\n" +
                            "https://facebook.com/LogoKnits/\n"+
                            "https://logoknits.com\n\n" +
                            "To opt out, reply to unsubscribe@sales.logoknits.com";

                    String fdMessageCanada = "Hi " + contacts.get(i)[1]+",\n\n" + "My name is Dave Van Anda.  I'm with Logo Knits where we design and manufacture custom knit blankets." +
                            "  Our blankets are very popular with fire departments all across the continent, so I'm reaching out to make sure that the " +  " has the chance to check them out too.\n\n"
                            + "Some key facts...\n\n"+ "-Custom Sample...NO CHARGE\n-100% Made in the USA\n-Door to door shipping (duties & taxes included)\n-Low minimum (12)\n-Can be personalized with names, ranks, etc.\n"
                            + "-Two sizes available (Bed and Stadium)\n\n"
                            + "If you're interested I'm happy to send over a pdf with some pictures and more information.\nOr just go ahead and send me your department's logo and we'll get started right away on a design proof so you can see how your blanket would look.(No Charge)\n\n" +
                            "Thanks for your time and I hope to hear from you,\n\n" +
                            "Dave Van Anda\n" +
                            "Logo Knits\n" +
                            "42A Cindy Lane, Ocean NJ\n" +
                            "www.logoknits.com/FD_CA\n\n" +
                            "To opt out, reply to unsubscribe@sales.logoknits.com";


                    String wildland = "Hi " + contacts.get(i)[1]+",\n\n" + "My name is Dave Van Anda.  I'm with Logo Knits where we design and manufacture custom knit blankets." +
                            "  Our product has taken off with structure departments all across the country, so I'm reaching out to make sure that wildland hand and engine crews have the chance to check them out too.\n\n"
                            + "Some key facts...\n\n"+ "-100% Made in the USA\n-Custom Sample...NO CHARGE\n-Low minimum (12)\n-Can be personalized with names, years, etc.\n"
                            + "-Two sizes available (Bed and Stadium)\n\n"
                            + "If you're interested I'm happy to send over a pdf with some pictures and more information.\n\n" +
                            "Thanks for your time and I hope to hear from you,\n\n" +
                            "Dave Van Anda\n" +
                            "Logo Knits\n" +
                            "42A Cindy Lane, Ocean NJ\n" +
                            "www.logoknits.com/FD\n\n" +
                            "To opt out, reply to unsubscribe@sales.logoknits.com";

                    String unionMessage = "Hi " + contacts.get(i)[1]+",\n\n" + "My name is Dave Van Anda.  I'm with Logo Knits where we design and manufacture custom knit blankets." +
                            "  Our product has taken off with local unions all across the country, so I'm reaching out to make sure that " + " has the chance to check them out too.\n\n"
                            + "Some key facts...\n\n"+ "-100% Made in the USA\n-Custom Sample...NO CHARGE\n-Low minimum (12)\n-Can be personalized with names, jobs, etc.\n"
                            + "-Two sizes available (Bed and Stadium)\n\n"
                            + "If you're interested I'm happy to send over a pdf with some pictures and more information.\n\n" +
                            "Thanks for your time and I hope to hear from you,\n\n" +
                            "Dave Van Anda\n" +
                            "Logo Knits\n" +
                            "42A Cindy Lane, Ocean NJ\n" +
                            "www.logoknits.com\n" +
                            "To opt out, reply to unsubscribe@sales.logoknits.com";

                    String schoolFollowUp = "Hi " + contacts.get(i)[1]+",\n\n" + "My name is Dave Van Anda.  I'm with Logo Knits where you've ordered " +  " blankets before." +
                            "\n\nIt's been a little while since you've ordered so I want to remind you what great Senior gifts our blankets make during graduation season.\n\n"
                            + "Our artwork capabilities are always improving...so we'd be happy to put together a new image proof for you to consider.\n\n" +
                            "Thanks for your time and I hope to hear from you,\n\n" +
                            "Dave Van Anda\n" +
                            "Logo Knits\n" +
                            "42A Cindy Lane, Ocean NJ\n" +
                            "www.logoknits.com\n" +
                            "To opt out, reply to unsubscribe@sales.logoknits.com";

                    String summerCamps = "Hi " + contacts.get(i)[1]+",\n\n" + "My name is Dave Van Anda.  I'm with Logo Knits where we design and knit custom blankets.\n\n" +
                            "Our blankets are really popular with schools and youth sports...so they're also a natural fit for summer camps to be used as souvenirs or even as bedding at sleep-away camps and I wanted to make sure that " + " has the chance to check them out.\n\n"
                            + "Some key facts...\n\n"+ "-100% Made in the USA\n-Custom Sample...NO CHARGE\n-Low minimum (12)\n-Can be personalized with names, years, etc.\n"
                            + "-Two sizes available (Bed and Stadium)\n\n"
                            + "If you're interested I'm happy to send over a pdf with some pictures and more information.\n\n" +
                            "Thanks for your time and I hope to hear from you,\n\n" +
                            "Dave Van Anda\n" +
                            "Logo Knits\n" +
                            "42A Cindy Lane, Ocean NJ\n" +
                            "www.logoknits.com/camps\n\n" +
                            "To opt out, reply to unsubscribe@sales.logoknits.com";

                    String universityAD = "Hi " + contacts.get(i)[1]+",\n\n" + "My name is Eric Finley.  I'm with Logo Knits where we design and manufacture custom blankets.\n\n" +
                            "Our blankets are really popular with schools as fundraisers, awards, or keepsakes.  With Fall Sports just around the corner I wanted to make sure that your school has the chance to take a look.\n\n"
                            + "Some key facts...\n\n"+ "-100% Made in the USA\n-Custom Sample...NO CHARGE\n-Low minimum (12)\n-Can be personalized with names, sports, etc.\n"
                            + "-Two sizes available (Bed and Stadium)\n\n"
                            + "If you're interested I'm happy to send over a pdf with some pictures and more information.\n\n" +
                            "Thanks for your time and I hope to hear from you,\n\n" +
                            "Eric Finley\n" +
                            "Logo Knits\n" +
                            "42A Cindy Lane, Ocean NJ\n" +
                             "732-382-9898\n" +
                            "https://logoknits.com/schools\n\n" +
                            "To opt out, reply to unsubscribe@sales.logoknits.com";



                    String sportsClubs = "Hi " + contacts.get(i)[1]+",\n\n" + "My name is Eric Finley.  I'm with Logo Knits where we design and knit custom blankets.\n\n" +
                            "Our blankets are great for fundraisers, awards, or fan giveaways so with the hockey season about to start I wanted to make sure that your team has the chance to take a look.\n\n"
                            + "Some key facts...\n\n"+ "-100% Made in the USA\n-Custom Sample...NO CHARGE\n-Low minimum (12)\n-Can be personalized with names, positions, etc.\n"
                            + "-Two sizes available (Bed and Stadium)\n\n"
                            + "If you're interested I can send over an info sheet with some pictures.\n\n" +
                            "Thanks for your time and I hope to hear from you,\n\n" +
                            "Eric Finley\n" +
                            "Logo Knits\n" +
                            "42A Cindy Lane, Ocean NJ\n" +
                             "732-382-9898\n" +
                            "https://logoknits.com/schools\n" +
                            "https://www.instagram.com/logoknits/\n" +
                            "https://www.facebook.com/logoknits/\n\n" +
                            "To opt out, reply to unsubscribe@sales.logoknits.com";

                    String golfClubs = "Hi " + contacts.get(i)[1]+",\n\n" + "My name is Eric Finley.  I'm with Logo Knits where we design and knit custom blankets.\n\n" +
                            "Our blankets are great for tournament giveaways, member gifts, or as retail items in your pro shop.  So with the Fall weather just around the corner I wanted to be sure that your club has the chance to check them out.\n\n"
                            + "Some key facts...\n\n"+ "-100% Made in the USA\n-Custom Sample...NO CHARGE\n-Low minimum (12)\n-Can be personalized with names, dates, etc.\n"
                            + "-Two sizes available (Bed and Stadium)\n\n"
                            + "If you're interested I can send over an info sheet with some pictures.\n\n" +
                            "Thanks for your time and I hope to hear from you,\n\n" +
                            "Eric Finley\n" +
                            "Logo Knits\n" +
                            "42A Cindy Lane, Ocean NJ\n" +
                            "732-382-9898\n" +
                            "https://www.facebook.com/logoknits/\n" +
                            "https://www.instagram.com/logoknits/\n" +
                            "https://logoknits.com\n\n" +
                            "To opt out, reply to unsubscribe@sales.logoknits.com";

                    // Now set the actual message
                    message.setText(universityAD);

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