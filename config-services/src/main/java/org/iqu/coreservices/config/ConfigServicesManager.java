package org.iqu.coreservices.config;

import java.util.Set;

public class ConfigServicesManager {

	private ConfigServiceProps configServiceProps;
	private Set<ServiceInfo> appServices;

	public ConfigServicesManager() {

		configServiceProps = new ConfigServiceProps();
		appServices = configServiceProps.getProperties();
	}

	public boolean addService(String hostname, String port, String url) {

		return appServices.add(new ServiceInfo(hostname, port, url));
	}

	public boolean removeService(String hostname, String port, String url) {

		for (ServiceInfo serviceInfo : appServices) {
			if (serviceInfo.getHostname() == hostname && serviceInfo.getPort() == port && serviceInfo.getUrl() == url) {
				return appServices.remove(serviceInfo);
			}
		}
		return false;
	}

	public Set<ServiceInfo> getSlaveApps() {
		return appServices;
	}
}
