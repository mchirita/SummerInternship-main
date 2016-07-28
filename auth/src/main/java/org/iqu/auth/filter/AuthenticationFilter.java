package org.iqu.auth.filter;

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

  @Override
  public void filter(ContainerRequestContext requestContext) {
    Client client = ClientBuilder.newClient();

    WebTarget webTarget = client
        .target("http://localhost:8080/auth/authenticate/" + requestContext.getCookies().get("token").getValue());

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.get();
    if (response.getStatus() != 200) {
      requestContext.abortWith(response);
    }

  }
}
