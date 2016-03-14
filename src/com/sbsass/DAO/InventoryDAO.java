package com.sbsass.DAO;

import java.util.List;

import javax.inject.Named;

import org.bson.BSONObject;

import com.sbsass.model.JsonData;

public interface InventoryDAO {
public BSONObject getPartDetails(String part);
public void updateCollection(String collectionName, List<String> fields);
public int createNewCollection(String collectionName, JsonData request);
}
