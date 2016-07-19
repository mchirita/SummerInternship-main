package org.iqu.webapp.events.management;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.iqu.slaveservices.entities.ErrorMessage;
import org.iqu.slaveservices.entities.Event;
import org.iqu.slaveservices.entities.Source;
import org.iqu.slaveservices.entities.TypeService;
import org.iqu.webapp.factory.ServiceFactory;
import org.iqu.webapp.news.management.NewsEndpoint;

import orq.iqu.slaveservices.events.EventsServiceSlave;

@Path("/")
public class EventsEndpoint {

	private Logger logger = Logger.getLogger(NewsEndpoint.class);
	private EventsServiceSlave eventsService = ServiceFactory.getEventsServiceInstance();

	/**
	 * Method that implements retrieve authors service.
	 */
	@Path("/authors")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveAuthors() {

		Set<String> retrieveAuthors = eventsService.retrieveAuthors();
		if (retrieveAuthors.isEmpty()) {
			ErrorMessage errorMessage = new ErrorMessage("Could not fetch authors, please try again later.");
			return Response.ok("{\"error\" : " + "\"" + errorMessage.getMessage() + "\"}").build();
		}

		return Response.status(200).entity("{\"authors\" : " + "\"" + retrieveAuthors + "\"}").build();
	}

	/**
	 * Service that retrieve events based on filters
	 */
	@Path("/")
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

	/**
	 * This method returns a list of sources where we grab our content.
	 */
	@Path("/sources")
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

	/**
	 * Thid method returns all types and subtypes of events.
	 */
	@Path("/types")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveTypes() {

		Set<TypeService> retrieveSources = eventsService.retrieveTypes();

		String type = "Concert";
		return Response.ok("[{\"Type\": " + "\"" + type + "\",\n\"Subtypes\" : [\"rock\", \"classical\"]}]").build();

	}

}
