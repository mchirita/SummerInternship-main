package org.iqu.slaveservices.entities;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Client - Entity that represents a client.
 * 
 * @author Alex Dragomir
 *
 */
public class Client {

  private String host;
  private String location;
  private int port;
  private boolean active;

  public Client(String host, int port, String location, boolean active) {
    super();
    this.host = host;
    this.port = port;
    this.location = location;
    this.active = active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  @JsonValue
  public String toString() {
    return "Client [host=" + host + ", location=" + location + ", port=" + port + ", active=" + active + "]";
  }

}
