package com.hdfc.accounts.service.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.hdfc.accounts.service.resource.HDFCAccounts;

@ApplicationPath("/api")
public class HDFCAccountsApplication extends Application {

	private static Set<Object> singletons;
	
	public HDFCAccountsApplication() {
		System.out.println("Loading Application Configurations...");
		singletons = new HashSet<Object>();
		singletons.add(new HDFCAccounts());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
