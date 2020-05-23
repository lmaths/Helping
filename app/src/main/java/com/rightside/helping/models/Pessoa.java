package com.rightside.helping.models;

import com.google.android.gms.maps.model.LatLng;

import lombok.Data;


@Data
public class Pessoa {
    private String nome;
    private String id;
    private String tipo = "";
    private double latitude, longitude;

    public Pessoa(String nome, String id, double latitude, double longitude, String tipo) {
        this.nome = nome;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tipo = tipo;
    }

    public LatLng getLatLng() {
        return new LatLng(latitude, longitude);
    }
}
