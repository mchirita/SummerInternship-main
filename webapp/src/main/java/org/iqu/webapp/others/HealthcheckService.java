package org.iqu.webapp.others;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.webapp.entities.Client;

/**
 * This class will return a list with all the configured clients and their
 * settings, and whether they are up and running or not,
 * 
 * @author Razvan Rosu
 *
 */
@Path("/healthcheck")
public class HealthcheckService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHealth() {

		List<Client> clients = new ArrayList<Client>();
		Client client = new Client("capp1.iquestgroup.com", 8080, "Cluj", true);
		Client client1 = new Client("capp2.iquestgroup.com", 8080, "Craiova", false);
		clients.add(client);
		clients.add(client);
		if (clients.isEmpty()) {
			Response.ok("[{\"Error\"}");
		}
		return Response.status(200).entity(clients).build();

	}

}
