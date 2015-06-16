import static spark.SparkBase.staticFileLocation;
import static spark.Spark.*;


public class HelloWorld {
    public static void main(String[] args) {
        MongoDB mongo = new MongoDB();

        staticFileLocation("/resources/main/"); // Static files
        get("/createUser", (req, res) -> {
            mongo.ajouter(req.params("nom"),req.params("prenom"),req.params("delit"));
            return 200;
        });
        /*
        get("/", (req, res) -> {
            //return req.params("ressources/main/index.html");
            //return "<a href=http://localhost:63342/FichierPoliceJudiciaire/build/resources/main/index.html>index.html<a>";
            //return "<a href=http://localhost:63342/FichierPoliceJudiciaire/build/resources/main/app/index.html>index.html<a>";
            res.redirect("http://localhost:63342/FichierPoliceJudiciaire/build/resources/main/app/index.html");
            return 0;
        });

        //get("/hello", (req, res) -> "Hello World");
        // matches "GET /hello/foo" and "GET /hello/bar"
        // request.params(":name") is 'foo' or 'bar'

        /*
        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });
        */
    }
}