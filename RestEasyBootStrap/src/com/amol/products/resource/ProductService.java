package com.amol.products.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("/price")
public class ProductService {

	public ProductService() {
		System.out.println("Geting Called...");
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getProductPrice(@QueryParam("pcode") String productCode) {
		if(productCode != null) {
			return (String.valueOf(this.hashCode())) + " >> " + productCode;
		}
		return (String.valueOf(this.hashCode()));
	}
}
