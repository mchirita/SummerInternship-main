package org.iqu.auth.user.management;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.entities.UserCredentials;



/**
 * 
 * @author Beniamin Savu
 * Service that authenticates the user and responds back with a token
 *
 */
@Path("/authenticate")
public class AuthenticateService {
	private SecureRandom random = new SecureRandom();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUser(UserCredentials userCredentials) {
		try{
			authenticate(userCredentials.getUsername(), userCredentials.getPassword());
			String token = issueToken();

			return Response.ok("{\"token\":" +"\"" + token + "\"}").build();
		}catch(Exception e){
			return Response.status(401).entity("{\"error\": \"Invalid Data\"}").build();
		}
	}

	private String issueToken() {
		return new BigInteger(130, random).toString(32);
	}

	private void authenticate(String username, String password) throws Exception{
		if(!(username.equals("johnny") && password.equals("hunter2"))){
			throw new Exception();
		}
	}
}
