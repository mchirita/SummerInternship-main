package org.iqu.coreservices.config;

import java.util.Set;

/**
 * ConfigServicesManager - Class that implements methods to add, remove, get
 * services.
 * 
 * @author Alex Dragomir
 *
 */
public class ConfigServicesManager {

	private ConfigServiceProps configServiceProps;
	private Set<ServiceInfo> appServices;

	/**
	 * Constructor.
	 */
	public ConfigServicesManager() {

		configServiceProps = new ConfigServiceProps();
		appServices = configServiceProps.getProperties();
	}

	/**
	 * This method is used to add a new service to the services set.
	 * 
	 * @param hostname
	 * @param port
	 * @param url
	 * @return true if the service can be added to the set and false otherwise.
	 */
	public boolean addService(String hostname, String port, String url) {

		return appServices.add(new ServiceInfo(hostname, port, url));
	}

	/**
	 * This method is used to remove an existing service from the services set.
	 * 
	 * @param hostname
	 * @param port
	 * @param url
	 * @return true if the service exists and can be removed from the set and
	 *         false otherwise.
	 */
	public boolean removeService(String hostname, String port, String url) {

		for (ServiceInfo serviceInfo : appServices) {
			ServiceInfo serviceInfoObject = new ServiceInfo(hostname, port, url);
			if (serviceInfo.getHostname().equals(serviceInfoObject)) {
				return appServices.remove(serviceInfo);
			}
		}
		return false;
	}

	/**
	 * This method is used to return the all the services.
	 * 
	 * @return a set that contains all services.
	 */
	public Set<ServiceInfo> getSlaveApps() {
		return appServices;
	}
}
