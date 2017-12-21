package com.ircts.pnrstatus.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/check")
public class PNRStatusResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPNRStatus(@QueryParam("pnr") String pnrNumber) {
		return "W/L 24 with pnr as " + pnrNumber;
	}
}
