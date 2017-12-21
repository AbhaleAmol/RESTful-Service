package com.amol.products.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.amol.products.resource.ProductService;


@ApplicationPath("/product")
public class AmolApplication extends Application {

	private Set<Object> appSingletons;
	
	public AmolApplication() {
		System.out.println("Preparing Objects...");
		appSingletons = new HashSet<>();
		appSingletons.add(new ProductService());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return appSingletons;
	}

	
}
