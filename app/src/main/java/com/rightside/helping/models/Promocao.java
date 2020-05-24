package com.rightside.helping.models;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promocao {

    private String id;
    private String nome;
    private String foto;
    private double precoOriginal;
    private double precoPromocao;

    public HashMap<String, Object> returnPromocao() {
        HashMap<String, Object> promocao = new HashMap<>();
        promocao.put("id", getId());
        promocao.put("nome", getNome());
        promocao.put("foto", getFoto());
        promocao.put("precoOriginal", getPrecoOriginal());
        promocao.put("precoPromocao", getPrecoPromocao());

        return promocao;
    }
}
