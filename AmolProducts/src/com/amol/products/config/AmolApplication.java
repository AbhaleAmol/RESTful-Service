package com.amol.products.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.amol.products.resource.ProductService;


/*@ApplicationPath("/product/*")*/
public class AmolApplication extends Application {

	private static Set<Object> appSingletons = null;
	private Set<Class<?>> appRequestScopes = null;
	
	public AmolApplication() {
		System.out.println("Constructing Resource Class Object...");
	
		appSingletons = new HashSet<Object>();
		appRequestScopes = new HashSet<>();
		appSingletons.add(ProductService.getProductService());
		//appSingletons.add(new ProductService());
		//productService = new ProductService();
	}

	@Override
	public Set<Object> getSingletons() {
		System.out.println("Call for creating Resource...");
		return appSingletons;
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return null;
	}
	
}
