package com.jdv.paths;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.jdv.beans.GeradorId;
import com.jdv.beans.classeId;

@Path("geraId")
public class GeraUserId {
	@Inject
	GeradorId generator;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response geraId(classeId user) {
		
		return Response.status(200).entity(generator.geraId(user)).build();
	}
}
