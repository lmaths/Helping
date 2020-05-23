package com.rightside.helping.models;

import com.google.android.gms.maps.model.LatLng;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Pessoa {
    private String nome;
    private String id;
    private String tipo = "";
    private double latitude, longitude;


    public LatLng getLatLng() {
        return new LatLng(latitude, longitude);
    }
}
