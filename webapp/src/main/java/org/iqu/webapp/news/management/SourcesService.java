package org.iqu.webapp.news.management;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.filter.CORSResponse;
import org.iqu.slaveservices.entities.Source;
import org.iqu.webapp.factory.ServiceFactory;

import orq.iqu.slaveservices.news.NewsServiceSlave;

/**
 * 
 * @author Mitroi Stefan-Daniel
 * 
 *         Service that retrive all sources
 * 
 */
@Path("/sources")
public class SourcesService {

  private NewsServiceSlave newsServiceSlave = ServiceFactory.getNewsServiceInstance();

  @GET
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retriveSources() {
    int status;
    String response = "";
    status = 0;

    Set<Source> retrieveSources = newsServiceSlave.retrieveSources();

    Source s = new Source("1", "BNR Brasov", "This is the official BNR site");
    if (s.getDisplayName().equals("BNR Brasov")) {
      status = 200;
      return Response.status(status).entity(s).build();
    } else {
      status = 404;
      response = "{\"error\" : \"Could not fetch sources, please try again later.\"}";
      return Response.status(status).entity(response).build();
    }
    // TO DO : retrive sources form database
  }
}
