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
 * 
 * Service that checks session validity
 *
 * @author Mitroi Stefan-Daniel
 * 
 * 
 */
@Path("/authenticate/{token}")
public class CheckSessionValidityService {

	@GET
	@CORSResponse
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkSessionValidity(@PathParam("token") String token) {

		TokenManager tokenManager = TokenManager.getInstance();
		String response = "";
		String userToken = tokenManager.getToken(token);
		int status;

		if ("".equals(userToken)) {
			status = 404;
			response = "{\"error\" : \"user does not exist\"}";
		} else if (!tokenManager.tokenValidator(token)) {
			status = 400;
			response = "{\"error\" : \"Session expired.\"}";
		} else {
			status = 200;
			response = "{\"userName\": \"" + tokenManager.getUser(token) + "\"}";
		}
		return Response.status(status).entity(response).build();
	}
}
