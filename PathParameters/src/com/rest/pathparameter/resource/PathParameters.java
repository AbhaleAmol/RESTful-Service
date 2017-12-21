package com.rest.pathparameter.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/calculate")
public class PathParameters {

	public PathParameters() {
		System.out.println("\nResource Called...\n");
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{firstNumber}/{secondNumber}")
	public double calculate(@PathParam("firstNumber") double firstNumber, @PathParam("secondNumber") double secondNumber) {
		return firstNumber + secondNumber;
	}
	
	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public double calculate(@QueryParam("firstNumber") double firstNumber) {
		return firstNumber;
	}*/
}
