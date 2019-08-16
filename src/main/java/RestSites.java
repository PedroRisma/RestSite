import com.google.gson.Gson;

import static spark.Spark.*;

public class RestSites {

    public static void main(String[] args) {

        ServiceCategories categories = new ServiceCategories();
        ServiceSites sites = new ServiceSites();
        port(8082);

        get("/sites", ((request, response) -> {
            response.type("application/json");
            return new Gson().toJsonTree(sites);
        }));

        get("/sites/:id/categories",  (request, response)->{
            response.type("application/json");
            return categories.getCategorie(request.params(":id"));
        });

    }

}
