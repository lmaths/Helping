package com.rightside.helping.models;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa{

    private String id, nome, descricao;
    private double latitude, longitude;

    public LatLng getLatLng() {
        return new LatLng(latitude, longitude);
    }
    private List<Produto> produtos;
    private List<Projeto> projetosVotados;
    private List<Promocao> promocoes;
    private Pontuacao pontuacao;
    private String email;
    private String telefone;
    private String imagem;
}
