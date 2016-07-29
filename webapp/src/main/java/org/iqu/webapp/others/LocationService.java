package org.iqu.webapp.others;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.webapp.factory.ServiceFactory;
import org.iqu.webapp.filter.CORSResponse;
import org.iqu.webapp.filter.Secured;

import orq.iqu.slaveservices.others.LocationServiceSlave;

@Path("/locations")
public class LocationService {

  private LocationServiceSlave locationServiceSlave = ServiceFactory.getLocationServiceInstance();

  @GET
  @CORSResponse
  @Secured
  @Produces(MediaType.APPLICATION_JSON)
  public Response getLocations() {

    // TODO: implement location retrieving

    return Response.ok("{\"locations\": [\"Cluj\", \"Craiova\", \"Sibiu\", \"Brasov\"]}").build();
  }

}