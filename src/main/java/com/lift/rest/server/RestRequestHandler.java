package com.lift.rest.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@Path("/rest")
public class RestRequestHandler {

	@Context
	private HttpServletResponse httpResponse;
	
	@Context
	private HttpServletRequest httpRequest;
	
	@Context 
	private HttpHeaders httpHeaders;
	

    @GET
    @Path("v1/{param}")
    public String testServer(@PathParam("param") String param) {
    	return "Server Response :" + param;
    }
 
}
