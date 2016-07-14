package org.iqu.webapp.events.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.webapp.entities.Authors;
import org.iqu.webapp.entities.ErrorMessage;

/**
 * RetrieveCategoriesService - Class that implements retrieve authors service.
 * 
 * @author Alex Dragomir
 *
 */
@Path("/authors")
public class RetrieveAuthorsService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveCategories() {
		Authors authors = new Authors();

		// ToDo get authors from db.
		authors.addCategory("Iron Maiden");
		authors.addCategory("Amy Lee");
		authors.addCategory("Passenger");
		authors.addCategory("iQuest");

		if (authors.isEmpty()) {
			ErrorMessage errorMessage = new ErrorMessage("Could not fetch authors, please try again later.");
			return Response.ok("{\"error\" : " + "\"" + errorMessage.getMessage() + "\"}").build();
		}

		return Response.status(200).entity("{\"authors\" : " + "\"" + authors.getAuthors() + "\"}").build();
	}
}
