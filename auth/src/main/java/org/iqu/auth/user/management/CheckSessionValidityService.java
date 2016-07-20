package org.iqu.auth.user.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.iqu.auth.token.TokenManager;
import org.iqu.auth.filter.CORSResponse;

/**
 * 
 * @author Mitroi Stefan-Daniel
 * 
 *         Service that checks session validity
 *
 */
@Path("/authenticate/{token}")
public class CheckSessionValidityService {

	@GET
	@CORSResponse
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkSessionValidity(@PathParam("token") String token) {

		TokenManager tm = TokenManager.getInstance();
		String response = "";
		int status;

		if (tm.getToken(token) == null || "".equals(tm.getToken(token))) {
			status = 404;
			response = "{\"error\" : \"user does not exist\"}";
		} else if (tm.isValid(token) == false) {
			status = 400;
			response = "{\"error\" : \"Session expired.\"}";
		} else {
			status = 200;
			response = "{\"userName\": \"" + tm.getUser(token) + "\"}";
		}
		return Response.status(status).entity(response).build();
	}
}
