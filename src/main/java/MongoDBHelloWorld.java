import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;

public class MongoDBHelloWorld {
    public static void main(String[] args) {
        try {
            //
            // Creates a new instance of MongoDBClient and connect to localhost
            // port 27017.
            //
            MongoClient client = new MongoClient(
                    new ServerAddress("localhost", 27017));

            //
            // Gets the peopledb from the MongoDB instance.
            //
            DB database = client.getDB("fichiersPoliceJudiciaire");

            //
            // Gets the persons collections from the database.
            //
            DBCollection collection = database.getCollection("vilains");

            Vilain jeanVal = new Vilain("Valjean","Jean","vol du soleil");
            //collection.insert((List<DBObject>) landYves);
            Gson gson = new Gson();
            DBObject obj = new BasicDBObject();
            obj = (DBObject) JSON.parse(gson.toJson(jeanVal));
            //collection.save(new BasicDBObject(gson.toJson(landYves)));
            collection.save(obj);

            //
            // Gets a single document / object from this collection.
            //
            DBObject document = collection.findOne();
            //DBObject document = collection.find(gson.fromJson({'nom': jeanVal.getNom()}));
            //
            // Prints out the document.
            //
            System.out.println(document);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}