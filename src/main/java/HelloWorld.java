import static spark.Spark.get;

public class HelloWorld {
    public static void main(String[] args) {

        get("/", (req, res) -> "Bonjour, veuillez vous identifier :");

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