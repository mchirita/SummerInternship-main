package org.iqu.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
      throws IOException, ServletException {
  	System.out.println("webb app filter");
    HttpServletResponse servletResponse = (HttpServletResponse) arg1;
    servletResponse.addHeader("Access-Control-Allow-Origin", "*");
    servletResponse.addHeader("Access-Control-Allow-Headers", "content-type");
    servletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");

    arg2.doFilter(arg0, arg1);
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {

  }

}
