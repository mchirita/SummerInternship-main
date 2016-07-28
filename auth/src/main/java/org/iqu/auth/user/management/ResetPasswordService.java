package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.iqu.auth.entities.ErrorMessage;
import org.iqu.auth.exception.ConfigurationException;
import org.iqu.auth.filter.CORSResponse;
import org.iqu.auth.filter.Secured;
import org.iqu.auth.passwordreset.EmailSender;
import org.iqu.auth.persistence.dao.DaoFactory;
import org.iqu.auth.persistence.dao.UserDaoImpl;
import org.iqu.auth.persistence.exception.AuthPersistenceException;
import org.iqu.auth.persistence.exception.DataBaseConnectionException;
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
  @Secured
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response resetPassword(@QueryParam("email") String toEmail) {

    EmailSender emailSender;
    TokenManager tokenManager = TokenManager.getInstance();
    String resetToken = "";
    String userName = "";

    ErrorMessage errorMessage;

    try {
      UserDaoImpl daoUser = DaoFactory.getInstance().getUserDao();
      userName = daoUser.findUser(toEmail);
      if ((!tokenManager.resetTokenValidatorForUser(userName))) {
        tokenManager.removeResetTokenWithUserName(userName);
        emailSender = new EmailSender();
        resetToken = emailSender.sendMail(userName, toEmail);
        tokenManager.generateResetToken(userName, resetToken);
      }

    } catch (AuthPersistenceException e) {
      errorMessage = new ErrorMessage(e.getMessage());
      return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
    } catch (ConfigurationException e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    } catch (DataBaseConnectionException e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
    return Response.status(Status.OK).build();
  }

}