package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.iqu.auth.entities.ErrorMessage;
import org.iqu.auth.entities.User;
import org.iqu.auth.entities.UserNameMessage;
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

		Convertor convertor = new Convertor();
		UserDto userDto = convertor.convertToUserDto(user);
		UserDaoImpl userDao = DaoFactory.getInstance().getUserDao();
		ErrorMessage errorMessage;
		UserNameMessage userNameMessage = new UserNameMessage(userDto.getUserName());

		try {
			userDao.insertUser(userDto);
		} catch (AuthPersistenceException e) {
			errorMessage = new ErrorMessage(e.getMessage());
			return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();

		}
		return Response.status(Status.OK).entity(userNameMessage).build();

	}

}
