package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.entities.User;
import org.iqu.auth.filter.CORSResponse;
import org.iqu.auth.passwordreset.EmailSender;
import org.iqu.auth.token.TokenManager;

/**
 * This class takes an email from the url and verifies if it's correctly spelled
 * and if it exists in the database and if yes, it sends and email with a reset
 * code.
 * 
 * @author Razvan
 *
 */
@Path("/users/password-reset")
public class ResetPasswordService {

	@POST
	@CORSResponse
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response resetPassword(@QueryParam("email") String toEmail) {
		
		EmailSender emailSender;
		User user = new User();	//TO DO: read from database 
		TokenManager tokenManager = new TokenManager();
		String resetToken="";
		
		if(tokenManager.resetTokenUserEmailMapContains(user)==true){
			return Response.status(200).build();
		}
		else{
			emailSender = new EmailSender();
			resetToken = emailSender.sendMail(user.getUserName(), toEmail);
			tokenManager.addToResetTokenUserEmailMap(user,resetToken);
			
		}
		return Response.status(200).build();
		// TO DO : search email in database
	}
}
