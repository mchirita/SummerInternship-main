package orq.iqu.slaveservices.dto;

/**
 * Client - Entity that represents a client.
 * 
 * @author Alex Dragomir
 *
 */
public class ClientDTO {

  private String host;
  private String location;
  private int port;
  private boolean active;

  public ClientDTO(String host, int port, String location, boolean active) {
    super();
    this.host = host;
    this.port = port;
    this.location = location;
    this.active = active;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (active ? 1231 : 1237);
    result = prime * result + ((host == null) ? 0 : host.hashCode());
    result = prime * result + ((location == null) ? 0 : location.hashCode());
    result = prime * result + port;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ClientDTO other = (ClientDTO) obj;
    if (active != other.active)
      return false;
    if (host == null) {
      if (other.host != null)
        return false;
    } else if (!host.equals(other.host))
      return false;
    if (location == null) {
      if (other.location != null)
        return false;
    } else if (!location.equals(other.location))
      return false;
    if (port != other.port)
      return false;
    return true;
  }

  public String getHost() {
    return host;
  }

  public String getLocation() {
    return location;
  }

  public int getPort() {
    return port;
  }

  public boolean isActive() {
    return active;
  }

}
