package org.iqu.webapp.others;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.iqu.webapp.factory.ServiceFactory;

import orq.iqu.slaveservices.others.RetrieveImageServiceSlave;

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
@Produces(MediaType.APPLICATION_JSON)
public class RetrieveImageService {

	private RetrieveImageServiceSlave retrieveImageService = ServiceFactory.getimageServiceInstance();

	@GET
	public Response retrieveImage(@PathParam("imageId") String imageId) {

		return Response.status(200).entity("{\"link\" : \"http://assets.realitatea.net/images/logo.jpg\"}").build();
	}

}
