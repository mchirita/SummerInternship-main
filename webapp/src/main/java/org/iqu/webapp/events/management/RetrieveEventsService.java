package org.iqu.webapp.events.management;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.slaveservices.entities.Event;
import org.iqu.webapp.factory.ServiceFactory;

import orq.iqu.slaveservices.events.EventsService;

/**
 * 
 * @author Mitroi Stefan-Daniel
 *
 *         Service that retrieve events based on filters
 */
@Path("/")
public class RetrieveEventsService {

	private EventsService eventsService = ServiceFactory.getEventsServiceInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveEvents(@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate,
			@QueryParam("type") String type, @QueryParam("subType") String subType,
			@QueryParam("sourceId") String sourceId, @QueryParam("author") String author,
			@QueryParam("location") String location) {

		Set<Event> retrieveEvents = eventsService.retrieveEvents(startDate, endDate, type, subType, sourceId, author,
				location);
		String response = "";
		if (startDate == null) {
			response = "{\"error\" : \"Requested location not available\"}";
			return Response.status(400).entity(response).build();
		} else {
			return Response.ok().build();
		}
	}
	// TO DO : implement filter of data
}