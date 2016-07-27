package org.iqu.webapp.others;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.iqu.webapp.factory.ServiceFactory;
import org.iqu.webapp.filter.CORSResponse;
import org.iqu.webapp.rest.entites.ErrorMessage;
import org.iqu.webapp.rest.entites.Image;

import orq.iqu.slaveservices.dto.ImageDTO;
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

  private static final Logger LOGGER = Logger.getLogger(ImageService.class);
  private ImageServiceSlave retrieveImageService = ServiceFactory.getimageServiceInstance();

  @GET
  @CORSResponse
  @Produces(MediaType.APPLICATION_JSON)
  public Response retrieveImage(@PathParam("imageId") String imageId) {

    ImageDTO imageDTO = retrieveImageService.getImage(imageId);
    Image image = new Image(imageDTO.getLink());

    System.out.println(image);

    if (image.getLink() == null) {
      LOGGER.error("Image not found!");
      ErrorMessage errorMessage = new ErrorMessage("Image not found!");

      return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    }

    return Response.status(Status.OK).entity(image).build();

  }

}
