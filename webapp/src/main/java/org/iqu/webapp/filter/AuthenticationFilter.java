package org.iqu.webapp.filter;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

/**
 *
 * Authentication filter for rest end points.
 * 
 * @author Mitroi Stefan-Daniel
 * 
 *
 */

@Provider
@Priority(Priorities.AUTHENTICATION)
@Secured
public class AuthenticationFilter implements ContainerRequestFilter {
  public static final String CHECKSESSIONVALIDITYPATH = "/auth/authenticate/";

  @Override
  public void filter(ContainerRequestContext requestContext) {
    Client client = ClientBuilder.newClient();
    WebTarget webTarget = client.target(buildTarget(requestContext).toString());
    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.get();
    if (response.getStatus() != Status.OK.getStatusCode()) {
      requestContext.abortWith(response);
    }
  }

  private StringBuilder buildTarget(ContainerRequestContext requestContext) {
    StringBuilder target = new StringBuilder();
    target.append(requestContext.getUriInfo().getAbsolutePath().getScheme()).append("://")
        .append(requestContext.getUriInfo().getRequestUri().getHost()).append(":")
        .append(requestContext.getUriInfo().getRequestUri().getPort()).append(CHECKSESSIONVALIDITYPATH)
        .append(requestContext.getCookies().get("token").getValue());
    return target;
  }
}
