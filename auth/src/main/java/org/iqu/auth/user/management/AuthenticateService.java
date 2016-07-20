package org.iqu.auth.user.management;

import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.iqu.auth.entities.User;
import org.iqu.auth.maps.UserPasswordMap;
import org.iqu.auth.token.TokenManager;
import org.iqu.auth.filter.CORSResponse;

/**
 * 
 * @author Beniamin Savu Service that authenticates the user and responds back
 *         with a token
 *
 */
@Path("/authenticate")
public class AuthenticateService {

	@POST
	@CORSResponse
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUser(User user) {

		Map<String, String> upm = UserPasswordMap.getInstance();
		String response = "";
		int status;
		TokenManager tokenManager = TokenManager.getInstance();
		String userToken = "";

		if (upm.containsKey(user.getUserName()) == false) {
			status = 401;
			response = "{\"error\": \"Invalid Data\"}";
		} else if (upm.get(user.getUserName()).equals(user.getPassword()) == false) {
			status = 401;
			response = "{\"error\": \"Invalid Data\"}";
		} else if (tokenManager.containUser(user) == false || tokenManager.isValid(user) == false) {
			userToken = tokenManager.addToken(user);
			tokenManager.printUtm();
			status = 200;
			response = "{\"token\":" + "\"" + userToken + "\"}";
		} else {
			status = 200;
			tokenManager.printUtm();
			response = "{\"token\":" + "\"" + tokenManager.getToken(user) + "\"}";
		}
		return Response.status(status).entity(response).build();
	}
}
