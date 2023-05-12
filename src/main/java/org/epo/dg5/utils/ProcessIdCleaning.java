package org.epo.dg5.utils;

import com.mongodb.client.*;
import org.bson.Document;

public class ProcessIdCleaning {
    public void setCleanTheDB(String epolineId) {
        String connectionToDB = "mongodb://nef-intg:fUnOhcNIxVg@luu2400i.internal.epo.org:30037/nef_intg_storage?authSource=admin&readPreference=primary&directConnection=true&ssl=false";
        try {
            MongoDatabase database;
            try (MongoClient mongoClient = MongoClients.create(connectionToDB)) {
                database = mongoClient.getDatabase("nef_intg_storage");
                Document searchQuery = new Document();
                searchQuery.put("request.representative.epolineId", epolineId);
                database.getCollection("informationRepProduct").deleteMany(searchQuery);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}
