package services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ServiceSites {

    private resourses.Site[] sites;


    public ServiceSites()
    {
        try {

            URL urlSite = new URL("https://api.mercadolibre.com/sites");
            try {
                URLConnection urlConnectionSite = urlSite.openConnection();
                urlConnectionSite.setRequestProperty("Accept", "application/json");
                urlConnectionSite.setRequestProperty("User-Agent", "Mozilla/5.0");
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnectionSite;

                BufferedReader inSite = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                Gson gsonSite = new Gson();
                sites = gsonSite.fromJson(inSite, resourses.Site[].class);
                Operador<ServiceSites> operador = new Operador<ServiceSites>();
                operador.bubbleSort(sites);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        Operador<ServiceSites> sitesOperador = new Operador<ServiceSites>();
        sitesOperador.bubbleSort(sites);
    }

    public JsonElement getSites() { return new Gson().toJsonTree(sites);}

    public resourses.Site getSite(int i)
    {
        return sites[i];
    }


}
