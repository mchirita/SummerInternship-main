package org.iqu.auth.email;

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

/**
 * 
 * @author Mitroi Stefan-Daniel
 * 
 *         Send mail with reset token
 *
 */
public class EmailService {
	private String host = "host";
	private String email = "email";
	private String password = "password";
	private String port = "port";
	private String messageSubject = "";
	private String messageText = "";

	public void sendMail(String toEmail) {
		Properties readProps = new Properties();
		Properties mailProps = new Properties();

		try (FileInputStream input = new FileInputStream("config/email.properties")) {
			readProps.load(input);
			mailProps.put("mail.smtp.user", readProps.getProperty(email));
			mailProps.put("mail.smtp.host", readProps.getProperty(host));
			mailProps.put("mail.smtp.port", readProps.getProperty(port));
			mailProps.put("mail.smtp.starttls.enable", "true");
			mailProps.put("mail.smtp.auth", "true");
			mailProps.put("mail.smtp.debug", "true");
			mailProps.put("mail.smtp.socketFactory.port", readProps.getProperty(port));
			mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			mailProps.put("mail.smtp.socketFactory.fallback", "false");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Session session = Session.getInstance(mailProps, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(readProps.getProperty(email), readProps.getProperty(password));
			}
		});
		messageText = genereatNewToken();
		messageSubject = "ResetPasswordCode";
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setText(messageText);
			msg.setSubject(messageSubject);
			msg.setFrom(new InternetAddress(readProps.getProperty(email)));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}

	private String genereatNewToken() {
		String token = "";
		// TO DO: find user in database and creat new token

		return token;
	}
}
