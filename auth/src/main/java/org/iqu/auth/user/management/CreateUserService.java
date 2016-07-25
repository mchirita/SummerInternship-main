package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.entities.User;
import org.iqu.auth.filter.CORSResponse;
import org.iqu.auth.persistence.dao.DaoFactory;
import org.iqu.auth.persistence.dao.UserDaoImpl;
import org.iqu.auth.persistence.dto.UserDto;
import org.iqu.auth.persistence.exception.AuthPersistenceException;
import org.iqu.auth.service.Convertor;

/**
 * UserService - Class that implements user rest service.
 * 
 * @author Alex Dragomir
 *
 */
@Path("/users")
public class CreateUserService {

	@POST
	@CORSResponse
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		int status = 200;
		String message = "";
		Convertor convertor = new Convertor();

		UserDto dtoUser = convertor.convertUserEntitieToUserDto(user);
		UserDaoImpl daoUser = DaoFactory.getInstance().getUserDao();

		message = "{\"userName\" : " + "\"" + dtoUser.getUserName() + "\"}";

		try {
			daoUser.addUser(dtoUser);
		} catch (AuthPersistenceException e) {
			message = "{\"error\" : " + "\"" + e.getMessage() + "\"}";
		}
		return Response.status(status).entity(message).build();

		// TO DO: save user in actual database and check for duplicate

	}

}
