package com.sbsass.resource;

import javax.ws.rs.core.Response;

import com.sbsass.model.DbCreateRequest;

public interface DatabaseManagementReource {
public Response create(DbCreateRequest request);
}
