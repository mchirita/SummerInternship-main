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

  private static volatile ConfigServicesManager instance = null;

  private ConfigServiceProps configServiceProps;
  private Set<ServiceInfo> appServices;

  /**
   * Constructor.
   */
  private ConfigServicesManager() {
    configServiceProps = new ConfigServiceProps();
    configServiceProps.loadFile();
    appServices = configServiceProps.getProperties();
  }

  /**
   * This method is used to ensure the return of the same instance of
   * ConfigServicesManager for all threads.
   */
  public static synchronized ConfigServicesManager getInstance() {
    if (instance == null) {
      synchronized (ConfigServicesManager.class) {
        if (instance == null) {
          instance = new ConfigServicesManager();
        }
      }
    }
    return instance;
  }

  /**
   * This method is used to add a new service to the services set.
   * 
   * @param hostname
   * @param port
   * @param location
   * @param webapp
   * @return true if the service can be added to the set and false otherwise.
   */
  public boolean addService(String hostname, int port, String location, String webapp) {
    return appServices.add(new ServiceInfo(hostname, port, location, webapp));
  }

  /**
   * This method is used to remove an existing service from the services set.
   * 
   * @param hostname
   * @param port
   * @param location
   * @param webapp
   * @return true if the service exists and can be removed from the set and
   *         false otherwise.
   */
  public boolean removeService(String hostname, int port, String location, String webapp) {

    for (ServiceInfo serviceInfo : appServices) {
      ServiceInfo serviceInfoObject = new ServiceInfo(hostname, port, location, webapp);
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
