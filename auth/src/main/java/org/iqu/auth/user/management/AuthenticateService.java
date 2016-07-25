package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.entities.User;
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

		String response = "";
		int status = 2;
		String invalidPasswordMessage = "invalid password";
		TokenManager tokenManager = TokenManager.getInstance();
		String userToken = "";
		Convertor convertor = new Convertor();
		UserCredentialsDto userCredentialsDto = convertor
				.convertUserCredentialsEntitieToUserCredentialsDto(userCredentials);
		UserDaoImpl userDao = DaoFactory.getInstance().getUserDao();

		if (userDao.findUserCredentials(userCredentialsDto)) {
			if ((!tokenManager.containUser(userCredentialsDto.getUserName())
					|| (!tokenManager.tokenValidatorForUser(userCredentialsDto.getUserName())))) {
				userToken = tokenManager.generateToken(userCredentialsDto.getUserName());
				status = 200;
				response = "{\"token\":" + "\"" + userToken + "\"}";
			} else {
				status = 200;
				response = "{\"token\":" + "\"" + tokenManager.getTokenForUser(userCredentialsDto.getUserName()) + "\"}";
			}
		} else {
			status = 401;
			response = "{\"error\": \"" + invalidPasswordMessage + "\"}";
		}
		return Response.status(status).entity(response).build();

	}
}
