package services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import resourses.Categorie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ServiceCategories {

    Categorie[] categories;

    public Categorie[] getCategories(String id)
    {

        try {
            URL urlCat = new URL("https://api.mercadolibre.com/sites/" + id + "/categories");

            try {
                URLConnection urlCatConnection = urlCat.openConnection();
                urlCatConnection.setRequestProperty("Accept", "application/json");
                urlCatConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                HttpURLConnection httpURLConnectionCat = (HttpURLConnection) urlCatConnection;

                BufferedReader inCat = new BufferedReader(new InputStreamReader(httpURLConnectionCat.getInputStream()));
                Gson gsonCat = new Gson();
                categories = gsonCat.fromJson(inCat, Categorie[].class);
                return categories;

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }




}
