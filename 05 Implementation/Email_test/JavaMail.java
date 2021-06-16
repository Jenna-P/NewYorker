



import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;


public class JavaMail {





    public static void main(String[] args) {
        sendingMail("jennafuttrup@gamil.com", "Jenna", "test");

    }


   public static String mEmail;
   public static String mName;
   public static String mMessage;


    //Constructor
//    public JavaMail(String mEmail, String mName, String mMessage) {
//
//        this.mEmail = mEmail;
//        this.mName = mName;
//        this.mMessage = mMessage;
//    }





    public static void sendingMail(String mEmail, String mName, String mMessage) {
        final String bodyEncoding = "UTF-8";

        //Creating properties
        Properties props = new Properties();

        //mail text
        StringBuffer sb = new StringBuffer();
        sb.append(mMessage);
        String html = sb.toString();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.quitwait", "false");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        try {
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(Utils.EMAIL, Utils.PASSWORD);
                }
            };

            //create mail session
            Session mSession = Session.getInstance(props, auth);

            //Creating MimeMessage object
            Message mm = new MimeMessage(mSession);


            //Setting sender address
            mm.setFrom(new InternetAddress("info@newyorker.dk"));
            //Adding receiver
            mm.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mEmail, false));
            //Adding subject
            mm.setSubject(mName);


            //set mail content
            Multipart mParts = new MimeMultipart();
            MimeBodyPart mTextPart = new MimeBodyPart();
            MimeBodyPart mFilePart = null;

            mTextPart.setText(html, bodyEncoding, "html");
            mParts.addBodyPart(mTextPart);

            mm.setContent(mParts);


            Transport.send(mm);



        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}

