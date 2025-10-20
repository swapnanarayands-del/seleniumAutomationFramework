package Utility;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailUtils {
	public static void sendTestReport(String reportPath) {
		final String senderEmail = "swapnanarayandevarkere@gmail.com";
		final String appPassword = "gmqsjtbpjmblrwgc";
		final String recipientEmail = "swapnanarayandevarkere@gmail.com";
//SMTP server properties

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

//		Create a session with Authentication
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);
			}
		});
		session.setDebug(true);
		try {
//			create Email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setSubject("Test Email From QA Automation");
//			message.setText("Hello\n This is a test email sent from java \n Regards,\nQA Team");
//			EMAIL body part
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello \n\n this is a test email from java \n\n Regards, \nQA Team");

//			Attachment Part
			MimeBodyPart attachmentPart = new MimeBodyPart();
//			String filePath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
			System.err.println("Attchemnt path is -" + reportPath);
			attachmentPart.attachFile(new File(reportPath));

//			combine body and attachments parts
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);

//			Send email

			Transport.send(message);
			System.out.println("Email sent successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
