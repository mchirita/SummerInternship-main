package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.iqu.auth.entities.ErrorMessage;
import org.iqu.auth.entities.TokenMessage;
import org.iqu.auth.entities.UserCredentials;
import org.iqu.auth.filter.CORSResponse;
import org.iqu.auth.persistence.dao.DaoFactory;
import org.iqu.auth.persistence.dao.UserDaoImpl;
import org.iqu.auth.persistence.dto.UserCredentialsDto;
import org.iqu.auth.service.Convertor;
import org.iqu.auth.token.TokenManager;

/**
 * Service that authenticates the user and responds back with a token
 * 
 * @author Beniamin Savu
 *
 */
@Path("/authenticate")
public class AuthenticateService {

	@POST
	@CORSResponse
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUser(UserCredentials userCredentials) {

		String userName = "";
		String userToken = "";

		ErrorMessage errorMessage;
		TokenMessage tokenMessage;
		TokenManager tokenManager = TokenManager.getInstance();
		Convertor convertor = new Convertor();
		UserCredentialsDto userCredentialsDto = convertor.convertToUserCredentialsDto(userCredentials);
		UserDaoImpl userDao = DaoFactory.getInstance().getUserDao();

		userName = userCredentialsDto.getUserName();

		if (userDao.findUserCredentials(userCredentialsDto)) {
			if ((!tokenManager.tokenValidatorForUser(userName))) {
				tokenManager.removeTokenWithUserName(userName);
				userToken = tokenManager.generateToken(userName);
				tokenMessage = new TokenMessage(userToken);
				return Response.status(Status.OK).entity(tokenMessage).build();
			}

			else {
				tokenMessage = new TokenMessage(tokenManager.getTokenForUser(userName));
				return Response.status(Status.OK).entity(tokenMessage).build();
			}
		} else {
			errorMessage = new ErrorMessage("Invalid password.");
			return Response.status(Status.UNAUTHORIZED).entity(errorMessage).build();
		}

	}
}
