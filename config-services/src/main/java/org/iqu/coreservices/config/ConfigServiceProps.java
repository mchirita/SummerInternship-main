package org.iqu.coreservices.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ConfigServiceProps {

	private Properties prop = new Properties();

	public void loadFile() {
		InputStream input = null;
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

		Set<ServiceInfo> appServices = new HashSet<ServiceInfo>();
		int length = Integer.parseInt(prop.getProperty("length"));
		for (int i = 1; i <= length; i++) {
			String hostname = prop.getProperty("hostname" + i);
			String port = prop.getProperty("port" + i);
			String url = prop.getProperty("url" + i);
			appServices.add(new ServiceInfo(hostname, port, url));
		}
		System.out.println(appServices);
		return appServices;
	}
}
