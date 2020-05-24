package com.rightside.helping.models;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private String id;
    private String nome;
    private double preco;
    private String foto;


    public HashMap<String, Object> returnProduto() {
        HashMap<String, Object> produto = new HashMap<>();
        produto.put("id", getId());
        produto.put("nome", getNome());
        produto.put("preco", getPreco());
        produto.put("foto", getFoto());
        return produto;
    }
}
