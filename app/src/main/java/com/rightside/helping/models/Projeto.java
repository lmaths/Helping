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
    private int pontos = 0;
    private int quantidadeDeVotos = 0;

    public Projeto(String id, String nome, String descricao, double latitude, double longitude) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

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
        projeto.put("pontos", getPontos());
        projeto.put("quantidadeDeVotos", getQuantidadeDeVotos());
        return projeto;
    }
}
