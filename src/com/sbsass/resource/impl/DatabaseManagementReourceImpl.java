package com.sbsass.resource.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sbsass.DAO.impl.InventoryDAOImpl;
import com.sbsass.model.DbCreateRequest;
import com.sbsass.resource.DatabaseManagementReource;
@Path("/dbmgmt")
public class DatabaseManagementReourceImpl implements DatabaseManagementReource{
	
	
	@GET
	@Path("/read")
	public Response read() {
		return Response.status(200).entity("test").build();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(DbCreateRequest request) {
		try{
			InventoryDAOImpl.getInstance().createNewCollection(request.getCollectionName(), request.getJsonData());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return Response.status(Status.OK).build();
	}

}
