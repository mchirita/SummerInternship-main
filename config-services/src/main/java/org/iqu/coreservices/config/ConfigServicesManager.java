package org.iqu.coreservices.config;

import java.util.Set;

public class ConfigServicesManager {

	ConfigServiceProps configServiceProps = new ConfigServiceProps();
	private Set<ServiceInfo> properties = configServiceProps.getProperties();

	public boolean addService(String hostname, String port, String url) {

		return properties.add(new ServiceInfo(hostname, port, url));
	}

	public boolean removeService(String hostname, String port, String url) {

		for (ServiceInfo serviceInfo : properties) {
			if (serviceInfo.getHostname() == hostname && serviceInfo.getPort() == port && serviceInfo.getUrl() == url) {
				return properties.remove(serviceInfo);
			}
		}
		return false;
	}

}
