package org.iqu.webapp.news.management;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.slaveservices.entities.ErrorMessage;
import org.iqu.webapp.factory.ServiceFactory;

import orq.iqu.slaveservices.news.NewsService;

/**
 * RetrieveCategoriesService - Class that implements retrieve categories
 * service.
 * 
 * @author Alex Dragomir
 *
 */
@Path("/categories")
public class RetrieveCategoriesService {

	private NewsService newsService = ServiceFactory.getNewsServiceInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveCategories() {

		Set<String> retrieveCategories = newsService.retrieveCategories();

		if (retrieveCategories.isEmpty()) {
			ErrorMessage errorMessage = new ErrorMessage("Could not fetch categories, please try again later.");
			return Response.ok("{\"error\" : " + "\"" + errorMessage.getMessage() + "\"}").build();
		}

		return Response.status(200).entity("{\"categories\" : " + "\"" + retrieveCategories + "\"}").build();
	}
}
