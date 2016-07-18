package org.iqu.webapp.news.management;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.slaveservices.entities.ErrorMessage;
import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.Source;
import org.iqu.webapp.factory.ServiceFactory;

import orq.iqu.slaveservices.news.NewsService;

public class NewsEndpoint {

	private NewsService newsService = ServiceFactory.getNewsServiceInstance();

	/**
	 * Service that will return all authors
	 */
	@Path("/authors")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveAuthors() {

		Set<String> retrieveAuthors = newsService.retrieveAuthors();

		String response = "";
		int status = 0;
		if (retrieveAuthors.size() > 0) {
			response = "{\"authors\" : " + "\"" + retrieveAuthors + "\"}";
			status = 200;
		} else {
			response = "{\"eror\" : \"Could not fetch authors, please try again later.\"}";
			status = 404;
		}

		return Response.status(status).entity(response).build();
	}

	/**
	 * Method that implements retrieve categories service.
	 */
	@Path("/categories")
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

	/**
	 * Retrieves news based on filters, that are sent as query parameters.
	 */
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNews(@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate,
			@QueryParam("categories") String categories, @QueryParam("about") String about,
			@QueryParam("sourceId") String sourceId, @QueryParam("author") String author,
			@QueryParam("location") String location) {

		Set<News> retrieveNews = newsService.retrieveNews(startDate, endDate, categories, about, sourceId, author,
				location);

		String response = "";
		int status = 200;

		try {
			long startDateLong = Long.parseLong(startDate);

			// TODO: implement actual filtering of data

		} catch (NumberFormatException e) {
			status = 400;
			response = "{ \"error\" : \"startDate parameter missing/invalid\" }";
		}

		return Response.status(status).entity(response).build();
	}

	/**
	 * Service that retrive all sources
	 */
	@Path("/sources")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveSources() {
		int status;
		String response = "";
		status = 0;

		Set<Source> retrieveSources = newsService.retrieveSources();

		Source s = new Source("1", "BNR Brasov", "This is the official BNR site");
		if (s.getDisplayName().equals("BNR Brasov")) {
			status = 200;
			return Response.status(status).entity(s).build();
		} else {
			status = 404;
			response = "{\"error\" : \"Could not fetch sources, please try again later.\"}";
			return Response.status(status).entity(response).build();
		}
		// TO DO : retrive sources form database
	}

}
