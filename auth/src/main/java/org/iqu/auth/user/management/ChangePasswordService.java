package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.iqu.auth.entities.ChangePasswordDetailes;
import org.iqu.auth.entities.ErrorMessage;
import org.iqu.auth.filter.CORSResponse;
import org.iqu.auth.filter.Secured;
import org.iqu.auth.persistence.dao.DaoFactory;
import org.iqu.auth.persistence.dao.UserDaoImpl;
import org.iqu.auth.persistence.dto.ChangePasswordDetailesDto;
import org.iqu.auth.persistence.exception.AuthPersistenceException;
import org.iqu.auth.persistence.exception.DataBaseConnectionException;
import org.iqu.auth.service.Convertor;
import org.iqu.auth.token.TokenManager;

/**
 * 
 *
 * Service that update password in database
 *
 * @author Mitroi Stefan-Daniel
 * 
 * 
 */
@Path("/users/password")
public class ChangePasswordService {

  @POST
  @CORSResponse
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Secured
  public Response changePassword(ChangePasswordDetailes passwordDetailes) {

    ErrorMessage errorMessage;
    String resetToken = passwordDetailes.getResetToken();
    TokenManager tokenManager = TokenManager.getInstance();

    if (!tokenManager.resetTokenValidatorForToken(resetToken)) {
      tokenManager.removeResetTokenWithToken(resetToken);
      errorMessage = new ErrorMessage("Could not change password. Invalid session.");
      return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
    } else {
      Convertor convertor = new Convertor();
      ChangePasswordDetailesDto changePasswordDto = convertor.convertToChangePasswordDetailesDto(passwordDetailes);
      UserDaoImpl daoUser;
      try {
        daoUser = DaoFactory.getInstance().getUserDao();
        String userName = tokenManager.getUserWithResetToken(resetToken);
        daoUser.updatePassword(changePasswordDto, userName);
        return Response.status(Status.OK).build();
      } catch (DataBaseConnectionException e) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
      } catch (AuthPersistenceException e) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
      }

    }
  }
}
