package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.entities.User;

/**
 * UserService - Class that implements user rest service.
 * 
 * @author iQuest
 *
 */
@Path("/users")
public class CreateUserService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {

		// ToDo save user after it is created.
		return Response.status(200).entity("{\"userName\" : " + "\"" + user.getUserName() + "\"}").build();

	}

}
