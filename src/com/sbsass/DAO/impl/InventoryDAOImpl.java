package com.sbsass.DAO.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.bson.BSONObject;
import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.sbsass.DAO.InventoryDAO;
import com.sbsass.config.ConfigEverything;
import com.sbsass.model.JsonData;

public class InventoryDAOImpl implements InventoryDAO{
	private static InventoryDAOImpl instance;
	@Override
	public BSONObject getPartDetails(String part) {
		MongoDatabase db = getDb();

		FindIterable<Document> iterable = db.getCollection("restaurants").find(new Document("address.zipcode", "10017"));
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document);
		    }
		});
		return null;
	}
	

	private MongoDatabase getDb() {
		ConfigEverything configEverything = ConfigEverything.getInstance();
		MongoDatabase db = configEverything.getDbClient().getDatabase("test");
		return db;
	}
	
	public int createNewCollection(String collectionName, JsonData request) {
		MongoDatabase db = getDb();
		db.createCollection(collectionName);
		MongoCollection<Document> collection = db.getCollection(collectionName);
		Gson gson = new Gson();
		
		collection.insertOne(Document.parse(gson.toJson(request)));
		return 0;
	}
	
	public static void main(String[] args){
		InventoryDAOImpl imple = new InventoryDAOImpl();
//		imple.getPartDetails("");
//		imple.createNewCollection("locaalls");
		MongoDatabase db = imple.getDb();
		db.createCollection("TestNewCollection4");
		MongoCollection<Document> collection = db.getCollection("TestNewCollection4");

		collection.insertOne(Document.parse("{'name':'mkyong', 'age':30}"));
		
		MongoIterable<Document> cursorDoc = collection.find();
		while (cursorDoc.iterator().hasNext()) {
			System.out.println(cursorDoc.iterator().next());
		}

		System.out.println("Done");
//		System.out.println(db.getCollection("locaalls"));
	}


	@Override
	public void updateCollection(String collectionName, List<String> fields) {
		// TODO Auto-generated method stub
		
	}


//	@Override
//	public void updateCollection(String collectionName, List<String> fields) {
//		// TODO Auto-generated method stub
//		MongoDatabase db = getDb();
////		db.getCollection(collectionName).updateMany(filter, update)
//	}
	
	public static InventoryDAOImpl getInstance() {
		
		if(instance == null) {
			synchronized(InventoryDAOImpl.class) {
				if(instance == null) {
					instance = new InventoryDAOImpl();
				}
			}
		}
		return instance;
	}


}
