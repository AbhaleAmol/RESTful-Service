package com.amol.products.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/price")
public class ProductService {

	
	/*public ProductService() {
		System.out.println("New Product Service is geting initialized...");
	}*/
	
	private ProductService() {
		System.out.println("New Product Service is geting initialized...");
	}
	
	public static ProductService getProductService() {
		return new ProductService();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getProductPrice(@QueryParam("pid") String productID) {
		if(productID != null) {
			//if(productID.equals("123")) {
				return (String.valueOf(this.hashCode())) + " >> " + productID;
			//}
		}
		return (String.valueOf(this.hashCode()));
	}
}
