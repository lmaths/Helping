package com.rightside.helping.models;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pessoa {
    private String nome;
    private String id;
    private String tipo = "";
    private double latitude, longitude;


    public LatLng getLatLng() {
        return new LatLng(getLatitude(), getLongitude());
    }

    public HashMap<String, Object> returnPessoa() {
        HashMap<String, Object> pessoa = new HashMap<>();
        pessoa.put("id", getId());
        pessoa.put("nome", getNome());
        pessoa.put("tipo", getTipo());
        pessoa.put("latitude", getLatitude());
        pessoa.put("longitude", getLongitude());
        return pessoa;
    }
}
