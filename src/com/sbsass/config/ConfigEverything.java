package com.sbsass.config;

import com.mongodb.MongoClient;
public class ConfigEverything {
	private static ConfigEverything instance;
	private static MongoClient dbClient;
	
	private ConfigEverything(){}
	
	public static ConfigEverything getInstance() {
		
		if(instance == null) {
			synchronized(ConfigEverything.class) {
				if(instance == null) {
					instance = new ConfigEverything();
					instance.setDbClient(new MongoClient("localhost", 27017));
				}
			}
		}
		return instance;
	}

	public MongoClient getDbClient() {
		return dbClient;
	}

	public void setDbClient(MongoClient dbClient) {
		ConfigEverything.dbClient = dbClient;
	}
	
}
