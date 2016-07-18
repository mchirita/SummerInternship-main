package org.iqu.auth.user.management;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Properties;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
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
		
		final String username = "stefan.mitroi22@gmail.com";
		final String password = "";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("stefan.mitroi22@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("msd_9522@yahoo.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	

		return Response.status(200).build();
		
		
		/*if (isFound(email) && isValidEmailAddress(email)) {

			SecureRandom random = new SecureRandom();
			String resetCode = new BigInteger(50, random).toString(32);

			return Response.status(200).entity("{\"Email\":" + "\"" + email + " found\"}").build();

		}
		return Response.status(404).entity("Email not found").build();
	*/}

	/*public boolean isValidEmailAddress(String email) {
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
*/
}
