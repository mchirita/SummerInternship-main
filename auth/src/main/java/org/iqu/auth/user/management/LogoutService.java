package org.iqu.auth.user.management;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.iqu.auth.token.TokenManager;

/**
 * Invalidates a user session and logs out.
 * 
 * @author Cristi Badoi
 */
@Path("/authenticate/{token}")
public class LogoutService {

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
}
