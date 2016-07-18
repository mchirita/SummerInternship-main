package org.iqu.webapp.events.management;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.slaveservices.entities.ErrorMessage;
import org.iqu.webapp.factory.ServiceFactory;

import orq.iqu.slaveservices.events.EventsServiceSlave;

/**
 * RetrieveAuthorsService - Class that implements retrieve authors service.
 * 
 * @author Alex Dragomir
 *
 */
@Path("/authors")
public class AuthorsService {

	private EventsServiceSlave eventsServiceSlave = ServiceFactory.getEventsServiceInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveAuthors() {

		Set<String> retrieveAuthors = eventsServiceSlave.retrieveAuthors();
		if (retrieveAuthors.isEmpty()) {
			ErrorMessage errorMessage = new ErrorMessage("Could not fetch authors, please try again later.");
			return Response.ok("{\"error\" : " + "\"" + errorMessage.getMessage() + "\"}").build();
		}

		return Response.status(200).entity("{\"authors\" : " + "\"" + retrieveAuthors + "\"}").build();
	}
}
