package br.com.alura.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class CategoriaId implements Serializable {

    private String nome;
    private String descricao;
}
