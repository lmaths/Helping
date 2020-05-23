package com.rightside.helping.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Marcador {

    private String id, nome, descricao;
    private double latitude, longitude;
}
