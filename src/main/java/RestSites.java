import com.google.gson.Gson;
import resourses.Categorie;
import services.ServiceCategories;
import services.ServiceSites;

import static spark.Spark.*;

public class RestSites {

    public static void main(String[] args) {

        ServiceSites sites = new ServiceSites();
        port(8082);

        get("/sites", ((request, response) -> {
            response.type("application/json");
            return new Gson().toJsonTree(sites.getSites());
        }));

        get("/sites/:id/categories",  (request, response)->{
            response.type("application/json");
            Categorie[] cat = new ServiceCategories().getCategories(request.params(":id"));

            if (cat!=null)
            {
                return new Gson().toJsonTree(cat);
            }
            return new Gson().toJson("ID resourses.Site Not Found");
        });

    }

}
