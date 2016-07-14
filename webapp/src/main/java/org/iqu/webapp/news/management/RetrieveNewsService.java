package org.iqu.webapp.news.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Retrieves news based on filters, that are sent as query parameters.
 * 
 * @author Cristi Badoi
 *
 */
@Path("/news")
public class RetrieveNewsService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getNews(@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate,
      @QueryParam("categories") String categories, @QueryParam("about") String about,
      @QueryParam("sourceId") String sourceId, @QueryParam("author") String author,
      @QueryParam("location") String location) {

    if (startDate == null || startDate.equals("")) {
      return Response.status(400).build();
    }

    // TODO: implement the actual filtering of the news

    return Response.ok().build();
  }

}
