package com.rightside.helping.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conquista {

    private int icone;
    private String nome;
    private String descricao;
    private int xp;
    private String tipo;

}
