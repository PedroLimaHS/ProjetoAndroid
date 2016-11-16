package com.example.pedro.motosapi.Http;

import com.example.pedro.motosapi.Model.Motos;
import com.example.pedro.motosapi.Model.MotosSearchResult;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by pedro on 05/11/2016.
 */
public class MotoParser {

    public static final String URL_SEARCH = "https://dl.dropboxusercontent.com/s/zmr3e6w5wtyeuzy/Jason%20projeto%20android.json";

    public static List<Motos> searchByTitle(String q) throws IOException {
        OkHttpClient client = new OkHttpClient();

        //Request request = new Request.Builder().url(String.format(URL_SEARCH, q)).build();
        Request request = new Request.Builder().url(URL_SEARCH).build();

        Response response = client.newCall(request).execute();
        if (response.networkResponse().code() == HttpURLConnection.HTTP_OK) {
            String json = response.body().string();

            Gson gson = new Gson();
            MotosSearchResult result =
                    gson.fromJson(json, MotosSearchResult.class);
            if (result != null) {
                return result.motos;
            }
        }
        return null;
    }
}


