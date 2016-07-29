package org.iqu.coreservices.config;

/**
 * ServiceInfo - Class that represents a service.
 * 
 * @author Alex Dragomir
 *
 */
public class ServiceInfo {

  private String hostname;
  private int port;
  private String location;
  private String webapp;

  public ServiceInfo() {

  }

  public ServiceInfo(String hostname, int port, String location, String webapp) {
    super();
    this.hostname = hostname;
    this.port = port;
    this.location = location;
    this.webapp = webapp;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getWebapp() {
    return webapp;
  }

  public void setWebapp(String webapp) {
    this.webapp = webapp;
  }
}
