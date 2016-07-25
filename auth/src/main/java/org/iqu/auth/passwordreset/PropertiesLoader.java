package org.iqu.auth.passwordreset;


import static org.iqu.auth.passwordreset.PropertiesConstants.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.iqu.auth.exception.ConfigurationException;

/**
 * Load configuration from email.properties file.
 * 
 * @author Mitroi Stefan-Daniel
 *
 */
public class PropertiesLoader {
	private Properties readProps;
	private Properties mailProps;

	public PropertiesLoader() {
		readProps = new Properties();
		mailProps = new Properties();
	}

	public Properties loadProperties() throws ConfigurationException {
		try (FileInputStream input = new FileInputStream(PATH)) {
			readProps.load(input);
			mailProps.put(SMTP_USER, readProps.getProperty(EMAIL));
			mailProps.put(SMTP_HOST, readProps.getProperty(HOST));
			mailProps.put(SMTP_PORT, readProps.getProperty(PORT));
			mailProps.put(SMTP_PASSWORD, readProps.getProperty(PASSWORD));
			mailProps.put(SMTP_STARTTLS_ENABLE, "true");
			mailProps.put(SMTP_AUTH, "true");
			mailProps.put(SMTP_DEBUG, "true");
			mailProps.put(SMTP_FACTORY_PORT, readProps.getProperty(PORT));
			mailProps.put(SMTP_FACTORY_CLASS, "javax.net.ssl.SSLSocketFactory");
			mailProps.put(SMTP_FACTORY_FCALLBACK, "false");
			
		} catch (IOException e) {
			throw new ConfigurationException("file corupted");
		}
		return mailProps;
	}
}
