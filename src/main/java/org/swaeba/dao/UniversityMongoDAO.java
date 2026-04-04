package org.swaeba.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;
import org.bson.Document;
import org.swaeba.config.MongoDBConnection;
import org.swaeba.model.University;

import java.util.ArrayList;
import java.util.List;

public class UniversityMongoDAO {
    public static void insertData(List<University> list){

        try {
            MongoDatabase db= MongoDBConnection.getDatabase();
            MongoCollection<Document> collection=db.getCollection("universities");
            List<Document> docs = new ArrayList<>();
            for(University u:list){
                Document doc= new Document("id",u.getId())
                        .append("name",u.getName())
                        .append("program",u.getProgram())
                        .append("city",u.getCity())
                        .append("country",u.getCountry())
                        .append("ranking",u.getRanking())
                        .append("fee",u.getFee())
                        .append("duration",u.getDuration());
                docs.add(doc);
            }
            collection.insertMany(docs, new InsertManyOptions().ordered(false));
            System.out.println("Data inserted into MongoDB!");
        }
        catch (Exception e) {
            if (e.getMessage().contains("E11000")) {
                System.out.println(" Duplicate data found. Skipping insert...");
            } else {
                System.err.println(" Error inserting into MongoDB: " + e.getMessage());
            }
        }
    }
}
