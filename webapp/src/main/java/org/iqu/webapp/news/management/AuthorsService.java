package org.iqu.webapp.news.management;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.filter.CORSResponse;
import org.iqu.webapp.factory.ServiceFactory;

import orq.iqu.slaveservices.news.NewsServiceSlave;

/**
 * 
 * @author Beniamin Savu
 * 
 *         Service that will return all authors
 *
 */

@Path("/authors")
public class AuthorsService {

  private NewsServiceSlave newsServiceSlave = ServiceFactory.getNewsServiceInstance();

  @GET
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retrieveAuthors() {

    Set<String> retrieveAuthors = newsServiceSlave.retrieveAuthors();

    String response = "";
    int status = 0;
    if (retrieveAuthors.size() > 0) {
      response = "{\"authors\" : " + "\"" + retrieveAuthors + "\"}";
      status = 200;
    } else {
      response = "{\"eror\" : \"Could not fetch authors, please try again later.\"}";
      status = 404;
    }

    return Response.status(status).entity(response).build();
  }
}
