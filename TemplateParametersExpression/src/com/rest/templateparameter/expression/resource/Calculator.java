package com.rest.templateparameter.expression.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/calculate/{firstNumber}/{secondNumber: \\d+}")
public class Calculator {
	
	/*public Calculator() {
		System.out.println("Constructing and Initializing Calculator...");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/mult")
	public double getMultiplication(@PathParam("firstNumber") double firstNumber, @PathParam("secondNumber") double secondNumber) {
		
		return firstNumber * secondNumber;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add")
	public double getAddition(@PathParam("firstNumber") double firstNumber, @PathParam("secondNumber") double secondNumber) {
		
		return firstNumber + secondNumber;
	}*/
	
	
	
	
	/*@PathParam("firstNumber")
	private int firstNumber;
	
	@PathParam("secondNumber")
	private int secondNumber;
	

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/mult")
	public double getMultiplication() {
		
		return firstNumber * secondNumber;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add")
	public double getAddition() {
		
		return firstNumber + secondNumber;
	}*/
	
	
	
	

	private double firstNumber;
	private double secondNumber;
	
	public Calculator(@PathParam("firstNumber") double firstNumber, @PathParam("secondNumber") double secondNumber) {
		System.out.println("Constructing and Initializing Calculator...");
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/mult")
	public double getMultiplication() {
		
		return firstNumber * secondNumber;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add")
	public double getAddition() {
		
		return firstNumber + secondNumber;
	}
}
