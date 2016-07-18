package org.iqu.auth.user.management;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.entities.User;
import org.iqu.auth.maps.UserPasswordMap;
import org.iqu.auth.token.Token;

/**
 * UserService - Class that implements user rest service.
 * 
 * @author Alex Dragomir
 *
 */
@Path("/users")
public class CreateUserService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {

		// ToDo save user after it is created.
		 Map<String, String> upm = UserPasswordMap.getInstance();
		 upm.put(user.getUserName(), user.getPassword());
		 System.out.println("UPM:");
		 for (Map.Entry<String, String> entryutm : upm.entrySet()) {
				System.out.println(entryutm.getKey() + " " + entryutm.getValue());
			}
		return Response.status(200).entity("{\"userName\" : " + "\"" + user.getUserName() + "\"}").build();

	}

}
