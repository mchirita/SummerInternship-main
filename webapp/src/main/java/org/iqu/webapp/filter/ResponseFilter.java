package org.iqu.webapp.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

@CORSResponse
public class ResponseFilter implements ContainerResponseFilter {

  @Override
  public void filter(ContainerRequestContext arg0, ContainerResponseContext arg1) throws IOException {
    arg1.getHeaders().add("Access-Control-Allow-Origin", "*");
  }

}
