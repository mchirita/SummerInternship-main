package org.iqu.webapp.others;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.iqu.webapp.entities.Client;
import org.iqu.webapp.entities.ErrorMessage;
import org.iqu.webapp.factory.ServiceFactory;
import org.iqu.webapp.filter.CORSResponse;
import org.iqu.webapp.filter.Secured;

import orq.iqu.slaveservices.dto.ClientDTO;
import orq.iqu.slaveservices.others.HealthCheckServiceSlave;

/**
 * This class will return a list with all the configured clients and their
 * settings, and whether they are up and running or not,
 * 
 * @author Razvan Rosu
 *
 */
@Path("/healthcheck")
public class HealthcheckService {

  HealthCheckServiceSlave healthCheckService = ServiceFactory.getOtherServiceInstance();

  @GET
  @CORSResponse
  @Secured
  @Produces(MediaType.APPLICATION_JSON)
  public Response getHealth() {

    Set<ClientDTO> clientDTOSet = healthCheckService.heathCheck();
    Set<Client> clients = new HashSet<Client>();

    for (ClientDTO clientDTO : clientDTOSet) {
      clients.add(new Client(clientDTO.getHost(), clientDTO.getPort(), clientDTO.getLocation(), clientDTO.isActive()));
    }

    if (clients.isEmpty()) {
      ErrorMessage errorMessage = new ErrorMessage("Error.");
      return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    }

    return Response.status(Status.OK).entity(clients).build();

  }

}
