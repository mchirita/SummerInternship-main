package org.iqu.auth.filter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.Provider;

/**
 *
 * Authentication filter for rest end points.
 * 
 * @author Mitroi Stefan-Daniel
 * 
 *
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		//UriBuilder uri = UriBuilder.fromUri("http://localhost:8080/auth/authenticate/token");
		System.out.println("filtru");
		URI uri;
		try {
			System.out.println(responseContext.getStatusInfo());
			responseContext.setStatus(500);
			
			uri = new URI("https://www.google.ro/");
			//Response.temporaryRedirect(uri);
	
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}



	//public void filter(ContainerRequestContext requestContext) {
		//System.out.println("filtru");
    
		//SecurityContext sc= requestContext.getSecurityContext();
		
		//URL url;
    //String query="";
    //URI uri;
		//try {
			
			

   // url = new URL("http://localhost:8080/auth/authenticate/token");

    /*try {
			url = new URL("http://localhost:8080/auth/authenticate/token");
			URLConnection urlc = url.openConnection();
	    urlc.setDoOutput(true);
	    urlc.setAllowUserInteraction(false);

	    //send query
	    PrintStream ps = new PrintStream(urlc.getOutputStream());
	    ps.print(query);
	    ps.close();



		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
; 

*/
	
//	}

	

}
