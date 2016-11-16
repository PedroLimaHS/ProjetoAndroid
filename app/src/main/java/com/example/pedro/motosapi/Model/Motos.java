package com.example.pedro.motosapi.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pedro on 06/11/2016.
 */
public class Motos {

    @SerializedName("moto_marca")
    public String marca;
    @SerializedName("modelo")
    public String modelo;
    @SerializedName("ano")
    public String ano;
    @SerializedName("Poster")
    public String poster;
}

