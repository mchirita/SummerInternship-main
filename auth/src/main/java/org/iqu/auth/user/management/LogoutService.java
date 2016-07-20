package org.iqu.auth.user.management;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.iqu.auth.token.TokenManager;
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
	public Response logout(@PathParam("token") String token) {
		
		String response = "";
		int status;
		TokenManager tm = TokenManager.getInstance();
		
		if (tm.isValid(token) == false) {
			status = 440;
			response = "{\"error\" : \"Session already expired.\"}";
		} else {
			tm.printUtm();
			tm.removeToken(token);
			status = 200;
			tm.printUtm();
		}
		return Response.status(status).entity(response).build();
		/*
		 * TODO: Check if the token is valid and active. If it is, mark it as
		 * unactive and return home page. If it's not, return matching error code.
		 */
	}

}
