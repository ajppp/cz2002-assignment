import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public static void main(String[] args) {

		final String username = "dummyemailforoodp"; // to be added
		final String password = "dummyemailOODP123"; // to be added

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dummyemailforoodp@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("dummyemailforoodp@gmail.com")); // to be added an email addr
			message.setSubject("Waitlist notification");
			message.setText("Dear Student,"
				+ "\n\n you have been waitlisted!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}