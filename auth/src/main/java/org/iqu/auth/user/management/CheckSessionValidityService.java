package org.iqu.auth.user.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 * 
 * @author Mitroi Stefan-Daniel
 * 
 * Service that checks session validity
 *
 */
@Path("/authenticate/{token}")
public class CheckSessionValidityService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkSessionValidity(@PathParam("token") String token){
		String response="";
		String tokenFromDataBase="stn123";
		int status;		
		if(tokenFromDataBase.equals(token)){
			response="{\"userName\": \"stefan\"}";
			status=200;
		}
		else{
			response="{\"error\" : \"user does not exist\"}";
			status=404;
		}
		return Response.status(status).entity(response).build();
		//TO DO : checks and validate username and token from database
		
	}
}
