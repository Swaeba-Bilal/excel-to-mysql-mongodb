package org.swaeba.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.swaeba.config.MongoDBConnection;
import org.swaeba.model.University;

import java.util.List;

public class UniversityMongoDAO {
    public static void insertData(List<University> list){

        try {
            MongoDatabase db= MongoDBConnection.getDatabase();
            MongoCollection<Document> collection=db.getCollection("universities");
            for(University u:list){
                Document doc= new Document("id",u.getId())
                        .append("name",u.getName())
                        .append("program",u.getProgram())
                        .append("city",u.getCity())
                        .append("country",u.getCountry())
                        .append("ranking",u.getRanking())
                        .append("fee",u.getFee())
                        .append("duration",u.getDuration());
                collection.insertOne(doc);
            }
            System.out.println("Data inserted into MongoDB!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
