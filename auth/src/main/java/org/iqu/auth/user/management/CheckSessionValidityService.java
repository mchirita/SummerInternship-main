package org.iqu.auth.user.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.iqu.auth.token.TokenManager;
import org.iqu.auth.entities.ErrorMessage;
import org.iqu.auth.entities.UserNameMessage;
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
		String userToken = tokenManager.getToken(token);
		ErrorMessage errorMessage;
		UserNameMessage userNameMessage;

		if ("".equals(userToken)) {
			errorMessage = new ErrorMessage("user does not exist.");
			return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		} else if (!tokenManager.tokenValidator(token)) {
			errorMessage = new ErrorMessage("Session expired.");
			tokenManager.removeTokenWithToken(token);
			return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
		} else {
			userNameMessage = new UserNameMessage(userToken);
			return Response.status(Status.OK).entity(userNameMessage).build();
		}
	}
}
