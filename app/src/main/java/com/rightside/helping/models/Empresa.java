package com.rightside.helping.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends Marcador{

    private List<Produto> produtos;
    private List<Projeto> projetosVotados;
    private List<Promocao> promocoes;
    private Pontuacao pontuacao;
    private String email;
    private String telefone;
    private String imagem;
}
