package org.iqu.auth.passwordreset;

import static org.iqu.auth.passwordreset.PropertiesConstants.SMTP_PASSWORD;
import static org.iqu.auth.passwordreset.PropertiesConstants.SMTP_USER;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.iqu.auth.exception.ConfigurationException;
import org.iqu.auth.token.TokenGenerator;

/**
 * Send email with reset token.
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class EmailSender {

	private Authenticator auth;
	private Properties props;
	private PropertiesLoader propsLoader;
	private TokenGenerator tokenGenerator;
	private String messageText;
	private String messageSubject;
	private static final Logger LOGGER = Logger.getLogger(EmailSender.class);

	public EmailSender() {

		propsLoader = new PropertiesLoader();
		tokenGenerator = new TokenGenerator();
	}

	public String sendMail(String userName, String toEmail) throws ConfigurationException {

		try {
			props = propsLoader.loadProperties();
		}  catch (ConfigurationException e) {
			LOGGER.error("can't load properties", e);
			throw new ConfigurationException("interanl problem");
		}
		auth = new SMTPAuthenticator(props.getProperty(SMTP_USER), props.getProperty(SMTP_PASSWORD));
		Session session = Session.getInstance(props, auth);
		messageText = tokenGenerator.generateToken(userName);
		messageSubject = "ResetPasswordCode";
		MimeMessage msg = new MimeMessage(session);

		try {
			msg.setText(messageText);
			msg.setSubject(messageSubject);
			msg.setFrom(new InternetAddress(props.getProperty(SMTP_USER)));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			Transport.send(msg);
		} catch (Exception mex) {
			LOGGER.error("email not sent", mex);
		}
		return messageText;
	}
}
