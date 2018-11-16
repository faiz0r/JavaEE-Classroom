package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.ClassService;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassService service;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllClass(String classroom) {
		return service.getAllClass();
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String addClass(String classroom) {
		return service.createClass(classroom);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateClass(@PathParam("id")Long id, String classroom) {
		return service.getAllClass();
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteClass(@PathParam("id") Long id) {
		return service.deleteClass(id);
	}
	
//	public void setService(AccountService service) {
//		this.service = service;
//	}

}
