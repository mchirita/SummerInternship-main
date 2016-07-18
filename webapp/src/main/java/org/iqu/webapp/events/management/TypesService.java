package org.iqu.webapp.events.management;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.slaveservices.entities.TypeService;
import org.iqu.webapp.factory.ServiceFactory;

import orq.iqu.slaveservices.events.EventsService;

/**
 * This class returns all types and subtypes of events.
 * 
 * @author Razvan Rosu
 *
 */
@Path("/types")
public class RetrieveTypesService {

	private EventsService eventsService = ServiceFactory.getEventsServiceInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveTypes() {

		Set<TypeService> retrieveSources = eventsService.retrieveTypes();

		String type = "Concert";
		return Response.ok("[{\"Type\": " + "\"" + type + "\",\n\"Subtypes\" : [\"rock\", \"classical\"]}]").build();

	}

}
