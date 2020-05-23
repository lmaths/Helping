package com.rightside.helping.models;

import com.google.android.gms.maps.model.LatLng;

import lombok.Data;

@Data
public class Pessoa {
    private String nome;
    private String id;
    private double latitude, longitude;

    public LatLng getLatLng() {
        return new LatLng(latitude, longitude);
    }
}
