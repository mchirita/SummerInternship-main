package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.entities.ChangePasswordDetailes;

@Path("/users/password")
public class ChangePasswordService {
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response changePassword(ChangePasswordDetailes passwordDetailes){
		String response="";
		int status;
		if(passwordDetailes.getNewPassword().equals("hunter3")&&passwordDetailes.getResetToken().equals("xKdcPoqw23qDEr")){
			status=200;
		}
		else{
			status=404;
			response="{\"error\" : \"Could not change password. Invalid session.\"}";
		}
		
		
		return Response.status(status).entity(response).build();
	}
	
}
