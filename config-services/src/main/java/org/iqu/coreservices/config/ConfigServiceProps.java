package org.iqu.coreservices.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ConfigServiceProps {

	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_PORT = "port";
	private static final String PROPERTY_HOSTNAME = "hostname";
	private static final String NUMBER_OF_HOSTS = "numberOfHosts";
	private static final String INPUT_FILE_PATH = "properties/configuration.properties";
	private Properties prop = new Properties();

	public void loadFile() {
		InputStream input = null;
		try {
			input = new FileInputStream(INPUT_FILE_PATH);
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Set<ServiceInfo> getProperties() {

		Set<ServiceInfo> appServices = new HashSet<ServiceInfo>();
		int numberOfHosts = Integer.parseInt(prop.getProperty(NUMBER_OF_HOSTS));
		for (int i = 1; i <= numberOfHosts; i++) {
			String hostname = prop.getProperty(PROPERTY_HOSTNAME + i);
			String port = prop.getProperty(PROPERTY_PORT + i);
			String url = prop.getProperty(PROPERTY_URL + i);
			appServices.add(new ServiceInfo(hostname, port, url));
		}
		System.out.println(appServices);
		return appServices;
	}
}
