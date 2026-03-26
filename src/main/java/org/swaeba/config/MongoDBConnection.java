package org.swaeba.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String CONNECTION_STRING="mongodb://localhost:27017";
    private static final String DATABASE_NAME="university_db";
    public static MongoDatabase getDatabase(){
        MongoClient client = MongoClients.create(CONNECTION_STRING);
        return client.getDatabase(DATABASE_NAME);
    }
}
