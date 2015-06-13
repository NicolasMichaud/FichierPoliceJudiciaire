import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;


public class HelloWorld {
    public static void main(String[] args) {
        staticFileLocation("resources/app/"); // Static files
        get("/", (req, res) -> {
            //return req.params("ressources/main/index.html");
            //return "<a href=http://localhost:63342/FichierPoliceJudiciaire/build/resources/main/index.html>index.html<a>";
            return "<a href=http://localhost:63342/FichierPoliceJudiciaire/build/resources/main/app/index2.html>index.html<a>";
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