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
import org.iqu.auth.persistence.dao.DaoFactory;
import org.iqu.auth.persistence.dao.UserDaoImpl;
import org.iqu.auth.persistence.dto.UserDto;
import org.iqu.auth.persistence.exception.AuthPersistenceException;
import org.iqu.auth.service.Convertor;
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
		TokenManager tokenManager = TokenManager.getInstance();
		String resetToken = "";
		Convertor convertor = new Convertor();
		String message = "";
		int status = 200;
		String userName="";
		
		UserDaoImpl daoUser = DaoFactory.getInstance().getUserDao();
		UserDto dtoUser;
		try {
			userName= daoUser.getUser(toEmail);
			if (tokenManager.containsResetToken(userName) == true) {
				return Response.status(200).build();
			} else {
				emailSender = new EmailSender();
				resetToken = emailSender.sendMail(userName, toEmail);
				tokenManager.generateResetToken(userName, resetToken);
			}
			
		} catch (AuthPersistenceException e) {
			status = 400;
			message ="{\"error\" : " + "\"" + e.getMessage() + "\"}";
		}

		return Response.status(status).entity(message).build();
	
	}
}
