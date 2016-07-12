package org.iqu.auth.user.management;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response resetPassword(@QueryParam("email") String email) {
		if (isFound(email) && isValidEmailAddress(email)) {

			SecureRandom random = new SecureRandom();
			String resetCode = new BigInteger(50, random).toString(32);

			return Response.status(200).entity("{\"Email\":" + "\"" + email + " found\"}").build();

		}
		return Response.status(404).entity("Email not found").build();
	}

	public boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	public boolean isFound(String email) {

		return true;

	}

}