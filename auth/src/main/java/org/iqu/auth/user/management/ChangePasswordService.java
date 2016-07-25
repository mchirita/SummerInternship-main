package org.iqu.auth.user.management;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.auth.entities.ChangePasswordDetailes;
import org.iqu.auth.filter.CORSResponse;
import org.iqu.auth.persistence.dao.DaoFactory;
import org.iqu.auth.persistence.dao.UserDaoImpl;
import org.iqu.auth.persistence.dto.ChangePasswordDetailesDto;
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
	public Response changePassword(ChangePasswordDetailes passwordDetailes) {

		String response = "";
		int status = 1;
	
		Convertor convertor = new Convertor();
		ChangePasswordDetailesDto changePasswordDto = convertor
				.convertChangePasswordDetailesEntitieToChangePasswordDetailesDto(passwordDetailes);
UserDaoImpl daoUser = DaoFactory.getInstance().getUserDao();

		
		return Response.status(status).entity(response).build();
		// TO DO : verify token, password in database and resetTokenUserMap
		// TO DO : check is token is valid and is in map

	}
}
