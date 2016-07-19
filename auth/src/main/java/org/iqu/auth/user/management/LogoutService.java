package org.iqu.auth.user.management;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

<<<<<<< HEAD
import org.iqu.auth.token.TokenManager;
=======
import org.iqu.auth.filter.CORSResponse;
>>>>>>> master

/**
 * Invalidates a user session and logs out.
 * 
 * @author Cristi Badoi
 */
@Path("/authenticate/{token}")
public class LogoutService {

<<<<<<< HEAD
	@DELETE
	public Response logout(@PathParam("token") String token) {
		
		String response = "";
		int status;
		TokenManager tm = TokenManager.getInstance();
		
		if (tm.getToken(token).isValid() == false) {
			status = 440;
			response = "{\"error\" : \"Session already expired.\"}";
		} else {
			tm.removeToken(token);
			status = 200;
		}
		return Response.status(status).entity(response).build();
		/*
		 * TODO: Check if the token is valid and active. If it is, mark it as
		 * unactive and return home page. If it's not, return matching error code.
		 */
	}
=======
  @DELETE
  @CORSResponse
  public Response logout(@PathParam("token") String token) {

    /*
     * TODO: Check if the token is valid and active. If it is, mark it as
     * unactive and return home page. If it's not, return matching error code.
     */

    return Response.status(200).build();
  }

>>>>>>> master
}
