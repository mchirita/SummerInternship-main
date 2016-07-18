package org.iqu.webapp.events.management;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.slaveservices.entities.Source;
import org.iqu.webapp.factory.ServiceFactory;

import orq.iqu.slaveservices.events.EventsService;

/**
 * This class returns a list of sources where we grab our content.
 * 
 * @author Razvan Rosu
 *
 */
@Path("/sources")
public class RetrieveSourcesService {

	private EventsService eventsService = ServiceFactory.getEventsServiceInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveSource() {
		int status;
		String response = "";
		status = 0;
		Source source = new Source("1", "BNR Brasov", "This is the official BNR site");
		Set<Source> retrieveSources = eventsService.retrieveSources();

		if (source.getDisplayName().equals("BNR Brasov")) {
			status = 200;
			return Response.status(status).entity(source).build();
		} else {
			status = 404;
			response = "\"error\" : \"Could not fetch sources, please try again later.\"";
			return Response.status(status).entity(response).build();
		}
	}

}
