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
    private String id;
    private String nome;
    private String email;
    private String foto;
    private String telefone;

    public HashMap<String, Object> returnPessoa() {
        HashMap<String, Object> pessoa = new HashMap<>();
        pessoa.put("id", getId());
        pessoa.put("nome", getNome());
        pessoa.put("email", getEmail());
        pessoa.put("foto", getFoto());
        pessoa.put("telefone", getTelefone());
        return pessoa;
    }
}
