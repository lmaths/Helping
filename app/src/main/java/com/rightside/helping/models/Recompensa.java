package com.rightside.helping.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recompensa {

    private String icone;
    private String nome;
    private String descricao;
    private String level;
    private String tipo;
}
