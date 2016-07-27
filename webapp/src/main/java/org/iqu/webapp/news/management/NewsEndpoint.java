package org.iqu.webapp.news.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.iqu.slaveservices.rest.consumer.models.AuthorsModel;
import org.iqu.slaveservices.rest.consumer.models.CategoriesModel;
import org.iqu.slaveservices.rest.consumer.models.ErrorMessageModel;
import org.iqu.slaveservices.rest.consumer.models.NewsModel;
import org.iqu.slaveservices.rest.consumer.models.SingleNewsModel;
import org.iqu.slaveservices.rest.consumer.models.SourceModel;
import org.iqu.slaveservices.rest.consumer.models.SourcesModel;
import org.iqu.webapp.factory.ServiceFactory;
import org.iqu.webapp.filter.CORSResponse;

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
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retrieveAuthors() {

    AuthorsDTO retrieveAuthors = newsService.retrieveAuthors();
    AuthorsModel authors = new AuthorsModel(retrieveAuthors.getAuthors());
    if (authors.isEmpty()) {
      ErrorMessageModel errorMessage = new ErrorMessageModel("Could not fetch authors, please try again later.");
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
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retriveCategories() {
    CategoriesDTO categoriesDTO = newsService.retrieveCategories();
    CategoriesModel categories = new CategoriesModel(categoriesDTO.getCategories());
    if (categoriesDTO.isEmpty()) {
      ErrorMessageModel errorMessage = new ErrorMessageModel("Could not fetch categories, please try again later.");
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
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNews(@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate,
      @QueryParam("categories") String categories, @QueryParam("about") String about,
      @QueryParam("sourceId") String sourceId, @QueryParam("author") String author,
      @QueryParam("location") String location) {
    NewsDTO retrieveNews = newsService.retrieveNews(startDate, endDate, categories, about, sourceId, author, location);
    NewsModel news = new NewsModel();
    for (SingleNewsDTO newsItem : retrieveNews.getNews()) {
      news.add(new SingleNewsModel(newsItem.getDate(), newsItem.getId(), newsItem.getTitle(), newsItem.getSubtitle(),
          newsItem.getDescription(), newsItem.getAuthors(), newsItem.getCategories(), newsItem.getSource(),
          newsItem.getBody(), newsItem.getImage_id(), newsItem.getThumbnail_id(), newsItem.getExternal_url()));
    }
    if (startDate == null) {
      return Response.status(Status.OK.getStatusCode()).entity(news).build();
    } else {
      return Response.ok("[{\"date\":1432911176, " + "\"id\":\"012031\", "
          + "\"title\":\"Cookiecliker is the new hit\", " + "\"subtitle\":\"A new game is out there\", "
          + "\"description\":\"A new addicting game has been created.\", " + "\"type\": \"concert\", "
          + "\"subtypes\":[\"rock\",\"rap\"], " + "\"source\":\"cnn\", " + "\"body\":\"Lorem ipsum dolor...\", "
          + "\"image_id\":\"012032\", " + "\"thumbnail_id\":\"012033\", "
          + "\"external_url\":\"http://www.cnn.com/article1\", " + "\"location\": \"Sibiu\"}]").build();
    }
  }

  /**
   * Service that retrive all sources
   */
  @Path("/sources")
  @GET
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retriveSources() {

    SourcesDTO retrieveSources = newsService.retrieveSources();
    SourcesModel sources = new SourcesModel();
    for (SourceDTO sourceDTO : retrieveSources.getSources()) {
      sources.addSource(new SourceModel(sourceDTO.getId(), sourceDTO.getDisplayName(), sourceDTO.getDescription(),
          sourceDTO.getImage()));
    }

    // Source s = new Source("1", "BNR Brasov", "This is the official BNR
    // site");
    if (sources.isEmpty()) {
      ErrorMessageModel errorMessage = new ErrorMessageModel("Could not fetch sources, please try again later.");
      LOGGER.error(errorMessage.getMessage());
      return Response.status(Status.NOT_FOUND.getStatusCode()).entity(errorMessage).build();
    }
    return Response.status(Status.OK.getStatusCode()).entity(sources).build();
    // TO DO : retrive sources form database
  }

}