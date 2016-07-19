package org.iqu.auth.user.management;

import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
<<<<<<< HEAD
import org.iqu.auth.entities.User;
import org.iqu.auth.maps.UserPasswordMap;
import org.iqu.auth.token.TokenManager;
=======

import org.iqu.auth.entities.UserCredentials;
import org.iqu.auth.filter.CORSResponse;
>>>>>>> master

/**
 * 
 * @author Beniamin Savu Service that authenticates the user and responds back
 *         with a token
 *
 */
@Path("/authenticate")
public class AuthenticateService {
<<<<<<< HEAD

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUser(User user) {
		
		Map<String, String> upm = UserPasswordMap.getInstance();
		String response = "";
		int status;
		TokenManager tm = TokenManager.getInstance();

		if (upm.containsKey(user.getUserName()) == false) {
			status = 401;
			response = "{\"error\": \"Invalid Data\"}";
		} else if (upm.get(user.getUserName()).equals(user.getPassword()) == false) {
			status = 401;
			response = "{\"error\": \"Invalid Data\"}";
		} else if (tm.containToken(user) == false) {
			tm.addToken(user);
			status = 200;
			response = "{\"token\":" + "\"" + tm.getToken(user).getToken() + "\"}";
		} else {
			if (tm.getToken(user).isValid() == false) {
				tm.addToken(user);
				status = 200;
				response = "{\"token\":" + "\"" + tm.getToken(user).getToken() + "\"}";
			} else {
				status = 200;
				response = "{\"token\":" + "\"" + tm.getToken(user).getToken() + "\"}";
			}
		}
		return Response.status(status).entity(response).build();
	}
=======
  private SecureRandom random = new SecureRandom();

  @POST
  @CORSResponse
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response authenticateUser(UserCredentials userCredentials) {
    String response = "";
    try {
      // TO DO check user credentials validity
      authenticate(userCredentials.getUsername(), userCredentials.getPassword());
      String token = issueToken();

      response = "{\"token\":" + "\"" + token + "\"}";

      return Response.ok(response).build();
    } catch (Exception e) {
      response = "{\"error\": \"Invalid Data\"}";
      return Response.status(401).entity(response).build();
    }
  }

  private String issueToken() {
    return new BigInteger(130, random).toString(32);
  }

  private void authenticate(String username, String password) throws Exception {
    if (!(username.equals("johnny") && password.equals("hunter2"))) {
      throw new Exception();
    }
  }
>>>>>>> master
}
