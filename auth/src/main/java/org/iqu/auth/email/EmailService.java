package org.iqu.auth.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	String messageSubject = "";
	String messageText = "";
	String fromEmail = "";
	String fromPassword = "";
	String host = "";
	String port = "";

	public void sendMail(String toEmail) {
		Properties props = new Properties();
		
		File f = new File(".");
		System.out.println(f.getAbsolutePath());
		try (FileInputStream input = new FileInputStream("/config/email.properties")) {
			props.load(input);
			props.put("mail.smtp.user", props.getProperty(fromEmail));
			props.put("mail.smtp.host", props.getProperty(host));
			props.put("mail.smtp.port", props.getProperty(port));
			props.put("mail.smtp.socketFactory.port", props.getProperty(port));
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, fromPassword);
			}
		});
		messageText = fromEmail;
		messageSubject = "ResetPasswordCode";
		// session.setDebug(true);
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setText(messageText);
			msg.setSubject(messageSubject);
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}
}
