import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;

/**
 * Created by leila on 09/06/2015.
 */
public class MongoDB {

    public MongoClient getClient() {
        return client;
    }

    public void setClient(MongoClient client) {
        this.client = client;
    }

    public DB getDatabase() {
        return database;
    }

    public void setDatabase(DB database) {
        this.database = database;
    }

    public DBCollection getCollection() {
        return collection;
    }

    public void setCollection(DBCollection collection) {
        this.collection = collection;
    }

    private MongoClient client; // Creates a new instance of MongoDBClient and connect to localhost port 27017.
    private DB database; // Gets the fichiersPoliceJudiciaire from the MongoDB instance.
    private DBCollection collection; // Gets the persons collections from the database.

    public MongoDB() {
        try {
            client = new MongoClient(new ServerAddress("localhost", 27017));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        database = client.getDB("fichiersPoliceJudiciaire");
        collection = database.getCollection("vilains");
    }
    /*
    ajouter(nom, prenom, delit) : Permet l'ajout d'un vilain à la base de données en donnant son nom, son prenom et le delit
     */
    public void ajouter(String nom, String prenom, String delit) {
        //try {
            Vilain vilain = new Vilain(nom,prenom,delit);
            //collection.insert((List<DBObject>) landYves);
            Gson gson = new Gson();
            DBObject obj = (DBObject) JSON.parse(gson.toJson(vilain));
            //collection.save(new BasicDBObject(gson.toJson(landYves)));
            collection.save(obj);
        /*} catch (UnknownHostException e) {
            e.printStackTrace();
        }*/
    }

    /*
    rechercher(parametre, valeur) : Permet la recherche d'un vilain dans la base de données
        l'utilisateur donne le paramètre qu'il recherche (nom, prenom ou delit) et la valeur de celui ci
     */
    public void rechercher(String parametre, String valeur){
        //
        // Gets a single document / object from this collection.
        //
        DBObject query = new BasicDBObject();
        DBCursor document;
        switch(parametre){                                  // La recherche se fait de la même façon peu importe le paramètre
            case "nom" : query.put("nom", valeur);          // Quand l'utilisateur cherche à partir du nom, il donne le nom qu'il cherche
                document = collection.find(query);          // On recherche la requête dans la base de données
                System.out.println(document.next());        // On affiche toute les données de la personne cherchées (pas seulement le nom)
                break;
            case "prenom" : query.put("prenom", valeur);
                document = collection.find(query);
                System.out.println(document.next());
                break;
            case "delit" : query.put("delit", valeur);
                document = collection.find(query);
                System.out.println(document.next());
                break;
        }
    }
}

