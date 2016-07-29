package org.iqu.webapp.news.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.iqu.webapp.entities.Authors;
import org.iqu.webapp.entities.Categories;
import org.iqu.webapp.entities.ErrorMessage;
import org.iqu.webapp.entities.News;
import org.iqu.webapp.entities.SingleNews;
import org.iqu.webapp.entities.Source;
import org.iqu.webapp.entities.Sources;
import org.iqu.webapp.factory.ServiceFactory;
import org.iqu.webapp.filter.CORSResponse;
import org.iqu.webapp.filter.Secured;

import orq.iqu.slaveservices.dto.AuthorsDTO;
import orq.iqu.slaveservices.dto.CategoriesDTO;
import orq.iqu.slaveservices.dto.NewsDTO;
import orq.iqu.slaveservices.dto.SingleNewsDTO;
import orq.iqu.slaveservices.dto.SourceDTO;
import orq.iqu.slaveservices.dto.SourcesDTO;
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
  @Secured
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retrieveAuthors() {

    AuthorsDTO retrieveAuthors = newsService.retrieveAuthors();
    Authors authors = new Authors(retrieveAuthors.getAuthors());
    if (authors.isEmpty()) {
      ErrorMessage errorMessage = new ErrorMessage("Could not fetch authors, please try again later.");
      LOGGER.error(errorMessage.getMessage());
      return Response.status(Status.NOT_FOUND.getStatusCode()).entity(errorMessage).build();
    }

    return Response.status(Status.OK.getStatusCode()).entity(authors).build();
  }

  /**
   * Method that implements retrieve categories service.
   */
  @Path("/categories")
  @GET
  @Secured
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retriveCategories() {
    CategoriesDTO categoriesDTO = newsService.retrieveCategories();
    Categories categories = new Categories(categoriesDTO.getCategories());
    if (categoriesDTO.isEmpty()) {
      ErrorMessage errorMessage = new ErrorMessage("Could not fetch categories, please try again later.");
      LOGGER.error(errorMessage.getMessage());
      return Response.status(Status.NOT_FOUND.getStatusCode()).entity(errorMessage).build();
    }

    return Response.status(Status.OK.getStatusCode()).entity(categories).build();
  }

  /**
   * Retrieves news based on filters, that are sent as query parameters.
   */
  @Path("/")
  @GET
  @Secured
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNews(@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate,
      @QueryParam("categories") String categories, @QueryParam("about") String about,
      @QueryParam("sourceId") String sourceId, @QueryParam("author") String author,
      @QueryParam("location") String location) {
    NewsDTO retrieveNews = newsService.retrieveNews(startDate, endDate, categories, about, sourceId, author, location);
    News news = new News();
    for (SingleNewsDTO newsItem : retrieveNews.getNews()) {
      news.add(new SingleNews(newsItem.getDate(), newsItem.getId(), newsItem.getTitle(), newsItem.getSubtitle(),
          newsItem.getDescription(), newsItem.getAuthors(), newsItem.getCategories(), newsItem.getSource(),
          newsItem.getBody(), newsItem.getImage_id(), newsItem.getThumbnail_id(), newsItem.getExternal_url()));
    }
    if (startDate == null) {
      ErrorMessage errorMessage = new ErrorMessage("Start Date Not Found.");
      LOGGER.error(errorMessage.getMessage());
      return Response.status(Status.BAD_REQUEST).entity(errorMessage).build();
    } else {
      return Response.ok().entity(news).build();
    }
  }

  /**
   * Service that retrive all sources
   */
  @Path("/sources")
  @GET
  @Secured
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retriveSources() {

    SourcesDTO retrieveSources = newsService.retrieveSources();
    Sources sources = new Sources();
    for (SourceDTO sourceDTO : retrieveSources.getSources()) {
      sources.addSource(
          new Source(sourceDTO.getId(), sourceDTO.getDisplayName(), sourceDTO.getDescription(), sourceDTO.getImage()));
    }

    // Source s = new Source("1", "BNR Brasov", "This is the official BNR
    // site");
    if (sources.isEmpty()) {
      ErrorMessage errorMessage = new ErrorMessage("Could not fetch sources, please try again later.");
      LOGGER.error(errorMessage.getMessage());
      return Response.status(Status.NOT_FOUND.getStatusCode()).entity(errorMessage).build();
    }
    return Response.status(Status.OK.getStatusCode()).entity(sources).build();
    // TO DO : retrive sources form database
  }

}