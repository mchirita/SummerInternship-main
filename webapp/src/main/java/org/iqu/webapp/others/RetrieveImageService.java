package org.iqu.webapp.others;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/images")
public class RetrieveImageService {

	@GET
	public Response retrieveImage(){
		return Response.ok().build();
	}
	
}
