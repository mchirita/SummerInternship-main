package org.iqu.webapp.others;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.slaveservices.entities.Client;
import org.iqu.webapp.factory.ServiceFactory;
import org.iqu.webapp.filter.CORSResponse;

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
  @Produces(MediaType.APPLICATION_JSON)
  public Response getHealth() {

    List<Client> heathCheck = healthCheckService.heathCheck();
    if (heathCheck.isEmpty()) {
      Response.ok("[{\"Error\"}");
    }
    return Response.status(200).entity(heathCheck).build();

  }

}
