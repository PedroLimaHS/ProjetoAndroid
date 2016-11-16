package com.example.pedro.motosapi.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pedro on 06/11/2016.
 */
public class MotosSearchResult {
    @SerializedName("Search")
    public List<Motos> motos;
}
