import com.google.gson.Gson;
import com.google.gson.JsonElement;

import static spark.Spark.*;

public class RestSites {

    public static void main(String[] args) {

        ServiceCategories categories = new ServiceCategories();
        ServiceSites sites = new ServiceSites();
        port(8082);

        get("/sites", ((request, response) -> {
            response.type("application/json");
            return new Gson().toJsonTree(new StandarResponse(StatusResponse.SUCCESS, sites.getSites()));
        }));

        get("/sites/:id/categories",  (request, response)->{
            response.type("application/json");
            JsonElement cat = new ServiceCategories().getCategorie(request.params(":id"));
            if (categories!=null)
            {
                return new Gson().toJson(new StandarResponse(StatusResponse.SUCCESS, cat));
            }
            return new Gson().toJson(new StandarResponse(StatusResponse.NOT_FOUND, "ID Site Not Found"));
        });

    }

}
