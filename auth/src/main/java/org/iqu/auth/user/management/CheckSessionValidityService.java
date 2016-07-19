package org.iqu.auth.user.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

<<<<<<< HEAD
import org.iqu.auth.token.TokenManager;
=======
import org.iqu.auth.filter.CORSResponse;
>>>>>>> master

/**
 * 
 * @author Mitroi Stefan-Daniel
 * 
 *         Service that checks session validity
 *
 */
@Path("/authenticate/{token}")
public class CheckSessionValidityService {

<<<<<<< HEAD
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkSessionValidity(@PathParam("token") String token) {

		TokenManager tm = TokenManager.getInstance();
		String response = "";
		int status;

		if (tm.getToken(token) == null) {
			status = 404;
			response = "{\"error\" : \"user does not exist\"}";
		} else if (tm.getToken(token).isValid() == false) {
			status = 400;
			response = "{\"error\" : \"Session expired.\"}";
		} else {
			status = 200;
			response = "{\"userName\": \"stefan\"}";
		}
		return Response.status(status).entity(response).build();
	}
=======
  @GET
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response checkSessionValidity(@PathParam("token") String token) {
    String response = "";
    String tokenFromDataBase = "stn123";
    int status;
    if (tokenFromDataBase.equals(token)) {
      response = "{\"userName\": \"stefan\"}";
      status = 200;
    } else {
      response = "{\"error\" : \"user does not exist\"}";
      status = 404;
    }
    return Response.status(status).entity(response).build();
    // TO DO : checks and validate username and token from database

  }
>>>>>>> master
}
