package org.iqu.auth.passwordreset;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.ConfigurationException;

import org.apache.log4j.Logger;
import org.iqu.auth.token.TokenGenerator;

public class EmailSender {
	private Authenticator auth;
	private Properties props;
	private PropertiesLoader propsLoader;
	private TokenGenerator tokenGenerator;
	private static final Logger logger = Logger.getLogger(EmailSender.class);
	public EmailSender() {

		propsLoader = new PropertiesLoader();
		tokenGenerator = new TokenGenerator();
	}

	public String sendMail(String userName, String toEmail) {

		try {
			props = propsLoader.loadProperties();
		} catch (ConfigurationException e) {
			logger.error("Can't load properties",e);
		}
		auth = new SMTPAuthenticator(props.getProperty("mail.smtp.user"), props.getProperty("password"));
		String messageText = "";
		String messageSubject = "";
		Session session = Session.getInstance(props, auth);

		messageText = tokenGenerator.generateToken(userName);
		messageSubject = "ResetPasswordCode";
		MimeMessage msg = new MimeMessage(session);
		try {

			msg.setText(messageText);
			msg.setSubject(messageSubject);
			msg.setFrom(new InternetAddress(props.getProperty("mail.smtp.user")));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			Transport.send(msg);
		} catch (Exception mex) {
			logger.error("mail not sent",mex);
		}
		return messageText;
	}
}
