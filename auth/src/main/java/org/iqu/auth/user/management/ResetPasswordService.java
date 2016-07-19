package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.iqu.auth.email.EmailService;

import org.iqu.auth.filter.CORSResponse;

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

		EmailService es = new EmailService();

		es.sendMail(toEmail);

		return Response.status(200).build();
		// TO DO : search email in database
	}
}
