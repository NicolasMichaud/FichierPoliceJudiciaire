import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class HelloWorld {
    public static void main(String[] args) {
        staticFileLocation("/resources/main"); // Static files
        get("/", (req, res) -> {return req.params("html/index.html");});

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