package org.iqu.coreservices.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ConfigServiceProps {

	Properties prop = new Properties();
	private InputStream input = null;

	public void loadFile() {
		try {
			input = new FileInputStream("properties/configuration.properties");
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

		Set<ServiceInfo> properties = new HashSet<ServiceInfo>();
		int length = Integer.parseInt(prop.getProperty("length"));
		for (int i = 1; i <= length; i++) {
			String hostname = prop.getProperty("hostname" + i);
			String port = prop.getProperty("port" + i);
			String url = prop.getProperty("url" + i);
			properties.add(new ServiceInfo(hostname, port, url));
		}
		System.out.println(properties);
		return properties;
	}
}
