package com.rightside.helping.models;

import com.google.android.gms.maps.model.LatLng;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private String nome;
    private String id;
    private double latitude, longitude;
    private String tipo = "";


    public LatLng getLatLng() {
        return new LatLng(latitude, longitude);
    }
}
