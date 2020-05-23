package com.rightside.helping.models;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

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
