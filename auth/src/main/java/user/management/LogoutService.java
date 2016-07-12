package user.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * REST Service implementing user logout functionality.
 * 
 * @ @author Cristi Badoi
 */
@Path("/authenticate/{token}")
public class LogoutService {

  /**
   * 
   * @param token
   * @return
   */
  @GET
  public Response doDelete(@PathParam("token") String token) {

    /*
     * TODO: Check if the token is valid/active. If it is, mark it as unactive
     * and return home page. If it's not, return session expired error code.
     */

    return Response.status(200).entity(token).build();
  }

}
