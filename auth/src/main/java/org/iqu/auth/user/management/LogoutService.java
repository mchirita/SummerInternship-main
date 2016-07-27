package org.iqu.auth.user.management;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.iqu.auth.token.TokenManager;
import org.iqu.auth.entities.ErrorMessage;
import org.iqu.auth.filter.CORSResponse;

/**
 * Invalidates a user session and logs out.
 * 
 * @author Cristi Badoi
 */
@Path("/authenticate/{token}")
public class LogoutService {

	@DELETE
	@CORSResponse
	@Produces(MediaType.APPLICATION_JSON)
	public Response logout(@PathParam("token") String token) {

		TokenManager tokenManager = TokenManager.getInstance();
		ErrorMessage errorMessage;
		if ((!tokenManager.tokenValidator(token))) {
			errorMessage = new ErrorMessage("Session already expired.");
			tokenManager.removeTokenWithToken(token);
			return Response.status(Status.UNAUTHORIZED).entity(errorMessage).build();
		} else {
			tokenManager.removeTokenWithToken(token);
			return Response.status(Status.OK).build();
		}
	}

}
