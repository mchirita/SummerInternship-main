package org.iqu.webapp.news.management;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.iqu.slaveservices.entities.News;
import org.iqu.slaveservices.entities.Source;
import org.iqu.webapp.factory.ServiceFactory;
import org.iqu.webapp.filter.CORSResponse;
import org.iqu.webapp.rest.entites.Authors;
import org.iqu.webapp.rest.entites.Categories;
import org.iqu.webapp.rest.entites.ErrorMessage;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;
import orq.iqu.slaveservices.news.NewsServiceSlave;

/**
 * NewsEndpoint - Class that holds the services for news end-point.
 * 
 * @author Alex Dragomir
 *
 */
@Path("/")
public class NewsEndpoint {

	private static final Logger LOGGER = Logger.getLogger(NewsEndpoint.class);
	private NewsServiceSlave newsService = ServiceFactory.getNewsServiceInstance();

	/**
	 * Service that will return all authors
	 */
	@Path("/authors")
	@GET
	@CORSResponse
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveAuthors() {
		AuthorsDTO retrieveAuthors = newsService.retrieveAuthors();
		Authors authors = new Authors(retrieveAuthors.getAuthors());
		if (authors.isEmpty()) {
			int status = 404;
			LOGGER.error("Authors not found");
			ErrorMessage errorMessage = new ErrorMessage("Could not fetch authors, please try again later.");

			return Response.status(status).entity(errorMessage).build();
		}

		return Response.status(200).entity(authors).build();
	}

	/**
	 * Method that implements retrieve categories service.
	 */
	@Path("/categories")
	@GET
	@CORSResponse
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveCategories() {
		CategoriesDTO categoriesDTO = newsService.retrieveCategories();
		Categories categories = new Categories(categoriesDTO.getCategories());
		if (categoriesDTO.isEmpty()) {
			int status = 404;
			ErrorMessage errorMessage = new ErrorMessage("Could not fetch categories, please try again later.");
			return Response.status(status).entity(errorMessage).build();
		}

		return Response.status(200).entity(categories).build();
	}

	/**
	 * Retrieves news based on filters, that are sent as query parameters.
	 */
	@Path("/")
	@GET
	@CORSResponse
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNews(@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate,
			@QueryParam("categories") String categories, @QueryParam("about") String about,
			@QueryParam("sourceId") String sourceId, @QueryParam("author") String author,
			@QueryParam("location") String location) {

		Set<News> retrieveNews = newsService.retrieveNews(startDate, endDate, categories, about, sourceId, author,
				location);

		String response = "{ \"date\":1432911176, " + "\"id\":\"012031\", "
				+ "\"title\":\"Cookiecliker is the new hit\", " + "\"subtitle\":\"A new game is out there\", "
				+ "\"description\":\"A new addicting game has been created.\", "
				+ "\"authors\":[\"Peter Parker\", \"Clarck Kent\"], " + "\"categories\":[\"games\", \"sci-fi\"], "
				+ "\"source\":\"cnn\", " + "\"body\":\"Lorem ipsum dolor...\", " + "\"image_id\":\"012032\", "
				+ "\"thumbnail_id\":\"012033\", "
				+ "\"external_url\":\"http://money.cnn.com/2016/07/16/technology/pokemon-go-crash-game/\", "
				+ "\"location\":\"craiova\" }";
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
	@CORSResponse
	@Produces(MediaType.APPLICATION_JSON)
	public Response retriveSources() {
		int status;
		String response = "";
		status = 0;

		Set<Source> retrieveSources = newsService.retrieveSources();

		// Source s = new Source("1", "BNR Brasov", "This is the official BNR
		// site");
		if (retrieveSources.isEmpty()) {
			status = 404;
			response = "{\"error\" : \"Could not fetch sources, please try again later.\"}";
			return Response.status(status).entity(response).build();
		}

		status = 200;
		return Response.status(status).entity("{\"sources\" : " + "\"" + retrieveSources + "\"}").build();
		// TO DO : retrive sources form database
	}

}