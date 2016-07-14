package org.iqu.webapp.news.management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * 
 * @author Alex Dragomir
 *
 */
@Path("/categories")
public class RetrieveCategoriesService {

	@GET
	public Response retriveCategories() {
		return Response.ok().build();
	}
}
