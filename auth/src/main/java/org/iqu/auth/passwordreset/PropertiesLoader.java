package org.iqu.auth.passwordreset;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.naming.ConfigurationException;

public class PropertiesLoader {
	private Properties readProps;
	private Properties mailProps;
	private String host = "host";
	private String email = "email";
	private String port = "port";
	private String password = "password";

	public PropertiesLoader() {
		readProps = new Properties();
		mailProps = new Properties();
	}

	public Properties loadProperties() throws ConfigurationException {
		try (FileInputStream input = new FileInputStream(
				"C:/Users/iQuest/Documents/SummerInternship-main/auth/email-config/email.properties")) {
			readProps.load(input);
			mailProps.put("mail.smtp.user", readProps.getProperty(email));
			mailProps.put("mail.smtp.host", readProps.getProperty(host));
			mailProps.put("mail.smtp.port", readProps.getProperty(port));
			mailProps.put("password", readProps.getProperty(password));
			mailProps.put("mail.smtp.starttls.enable", "true");
			mailProps.put("mail.smtp.auth", "true");
			mailProps.put("mail.smtp.debug", "true");
			mailProps.put("mail.smtp.socketFactory.port", readProps.getProperty(port));
			mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			mailProps.put("mail.smtp.socketFactory.fallback", "false");

		} catch (IOException e) {
			throw new ConfigurationException("file corupted");
		}
		return mailProps;
	}
}
