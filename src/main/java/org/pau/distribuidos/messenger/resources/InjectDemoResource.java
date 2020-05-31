package org.pau.distribuidos.messenger.resources;

import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("customHeaderValue") String header,
											@CookieParam("name") String cookie){
		return matrixParam + header + cookie;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo,
										@Context HttpHeaders headers) {
		
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return path + cookies;
	}

}
