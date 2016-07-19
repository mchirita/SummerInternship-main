package org.iqu.webapp.others;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.iqu.auth.filter.CORSResponse;
import org.iqu.webapp.factory.ServiceFactory;

import orq.iqu.slaveservices.others.ImageServiceSlave;

/**
 * 
 * @author Beniamin Savu
 * 
 *         Service that retrieves images, based on their ID as returned by the
 *         retrieve news/event endpoint. It should return the full binary
 *         object.
 *
 */
@Path("/images/{imageId}")
public class ImageService {

  private ImageServiceSlave retrieveImageService = ServiceFactory.getimageServiceInstance();

  @GET
  @CORSResponse
  public Response retrieveImage(@PathParam("imageId") String imageId) {

    return Response.ok().build();
  }

}
