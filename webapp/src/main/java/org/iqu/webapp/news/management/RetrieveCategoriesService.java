package org.iqu.webapp.news.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.webapp.news.categories.Categories;
import org.iqu.webapp.news.error.ErrorMessage;

/**
 * RetrieveCategoriesService - Class that implements retrieve categories
 * service.
 * 
 * @author Alex Dragomir
 *
 */
@Path("/categories")
public class RetrieveCategoriesService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveCategories() {
		Categories categories = new Categories();

		// ToDo get categories from db.
		categories.addCateg("music");
		categories.addCateg("music");
		categories.addCateg("politics");
		categories.addCateg("IT");

		if (categories.isEmpty()) {
			ErrorMessage errorMessage = new ErrorMessage("Could not fetch categories, please try again later.");
			return Response.ok("{\"error\" : " + "\"" + errorMessage.getMessage() + "\"}").build();
		}

		return Response.status(200).entity("{\"categories\" : " + "\"" + categories.getCategories() + "\"}").build();
	}
}
