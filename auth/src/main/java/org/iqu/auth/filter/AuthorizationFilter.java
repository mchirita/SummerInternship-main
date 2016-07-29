package org.iqu.auth.filter;

import java.util.List;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * Authorization filter for rest end points.
 * 
 * @author Mitroi Stefan-Daniel
 *
 *
 */
@Secured
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext requestContext) {

  }

  private void checkPermissions(List<Role> allowedRoles) {

  }
}