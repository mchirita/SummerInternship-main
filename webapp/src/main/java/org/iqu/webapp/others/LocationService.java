package org.iqu.webapp.others;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/locations")
public class LocationService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getLocations() {

    // TODO: implement location retrieving

    return Response.ok().build();
  }

}