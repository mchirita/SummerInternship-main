package org.iqu.coreservices.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * ConfigServiceProps - Class used to configure service properties.
 * 
 * @author Alex Dragomir
 *
 */
public class ConfigServiceProps {

  private static final String PROPERTY_PORT = "port";
  private static final String PROPERTY_WEBAPP = "webapp";
  private static final String PROPERTY_HOSTNAME = "hostname";
  private static final String PROPERTY_LOCATION = "location";
  private static final String NUMBER_OF_HOSTS = "numberOfHosts";
  private static final String INPUT_FILE_PATH = "/iqu/slave-app-config/slaveServices.properties";

  private Properties prop = new Properties();

  /**
   * This method is used to load an input file, representing the properties
   * file, and if it is not possible an IOException error occurs.
   */
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

  /**
   * This method is used to create and return a set of services.
   * 
   * @return set of services.
   */
  public Set<ServiceInfo> getProperties() {

    Set<ServiceInfo> appServices = new HashSet<ServiceInfo>();
    int numberOfHosts = Integer.parseInt(prop.getProperty(NUMBER_OF_HOSTS));
    for (int i = 1; i <= numberOfHosts; i++) {
      String hostname = prop.getProperty(PROPERTY_HOSTNAME + i);
      String port = prop.getProperty(PROPERTY_PORT + i);
      String location = prop.getProperty(PROPERTY_LOCATION + i);
      String webapp = prop.getProperty(PROPERTY_WEBAPP + i);
      System.out.println(port);
      int portIntegerValue = Integer.parseInt(port);

      appServices.add(new ServiceInfo(hostname, portIntegerValue, location, webapp));
    }
    return appServices;
  }

}
