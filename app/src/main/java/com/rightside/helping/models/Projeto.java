package com.rightside.helping.models;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Projeto {

    private String id;
    private String nome;
    private String descricao;
    private double latitude, longitude;

    public LatLng getLatLng() {
        return new LatLng(latitude, longitude);
    }

    public HashMap<String, Object> returnProjeto() {
        HashMap<String, Object> projeto = new HashMap<>();
        projeto.put("id", getId());
        projeto.put("nome", getNome());
        projeto.put("descricao", getDescricao());
        projeto.put("latitude", getLatitude());
        projeto.put("longitude", getLongitude());
        return projeto;
    }
}
