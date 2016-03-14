package com.sbsass.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DbCreateRequest implements Serializable{

private static final long serialVersionUID = 7766511779288104781L;
private String collectionName;
private JsonData jsonData;

public DbCreateRequest() {}

public String getCollectionName() {
	return collectionName;
}
public void setCollectionName(String collectionName) {
	this.collectionName = collectionName;
}
public JsonData getJsonData() {
	return jsonData;
}
public void setJsonData(JsonData jsonData) {
	this.jsonData = jsonData;
}
}
