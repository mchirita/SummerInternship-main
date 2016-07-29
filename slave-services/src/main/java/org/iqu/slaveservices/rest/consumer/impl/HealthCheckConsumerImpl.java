package org.iqu.slaveservices.rest.consumer.impl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.iqu.coreservices.config.ServiceInfo;
import org.iqu.slaveservices.rest.consumer.BaseConsumer;
import org.iqu.slaveservices.rest.consumer.HealthCheckConsumer;

import orq.iqu.slaveservices.dto.ClientDTO;

public class HealthCheckConsumerImpl extends BaseConsumer implements HealthCheckConsumer {

  private static final String PING_PATH = "ping";

  @Override
  public Set<ClientDTO> getHealth(Set<ServiceInfo> servicesInfo) {
    Invocation.Builder invocationBuilder;
    WebTarget webTarget;
    Response response;
    ClientDTO clientDTO;
    Set<ClientDTO> clientList = new HashSet<ClientDTO>();

    Client client = ClientBuilder.newClient();
    for (ServiceInfo service : servicesInfo) {

      webTarget = client.target(buildTarget(service, PING_PATH));

      invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
      response = invocationBuilder.head();

      if (response.getStatus() == Status.OK.getStatusCode()) {
        clientDTO = new ClientDTO(service.getHostname(), service.getPort(), service.getLocation(), true);
      } else {
        clientDTO = new ClientDTO(service.getHostname(), service.getPort(), service.getLocation(), false);
      }
      clientList.add(clientDTO);
    }
    return clientList;
  }

}
