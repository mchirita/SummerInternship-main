package org.iqu.auth.user.management;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.email.EmailService;

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
	public Response resetPassword(@QueryParam("email") String toEmail) throws IOException {
		EmailService es = new EmailService();
		es.sendMail(toEmail);
		
		
		// String fromEmail = "stefan.mitroi22@gmail.com";
		// String fromPassword = "";

		// String host = "smtp.gmail.com";
		// String port = "465";

		// props.put("mail.smtp.user", fromEmail);
		// props.put("mail.smtp.host", host);
		// props.put("mail.smtp.port", port);
		// props.put("mail.smtp.socketFactory.port", port);

		/*String messageSubject = "";
		String messageText = "";
		String fromEmail = "";
		String fromPassword = "";
		String host = "";
		String port = "";

		Properties props = new Properties();
		File f = new File("config/email.properties");
		System.out.println(f.getAbsolutePath());
		try (FileInputStream input = new FileInputStream("config/email.properties")) {
			props.load(input);
			props.put("mail.smtp.user", props.getProperty(fromEmail));
			props.put("mail.smtp.host", props.getProperty(host));
			props.put("mail.smtp.port", props.getProperty(port));
			props.put("mail.smtp.socketFactory.port", props.getProperty(port));
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, fromPassword);
			}
		});
		messageText = fromEmail;
		messageSubject = "ResetPasswordCode";
		// session.setDebug(true);
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setText(messageText);
			msg.setSubject(messageSubject);
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
		}*/
		return Response.status(200).build();
		// TO DO : search email in database
	}
}
