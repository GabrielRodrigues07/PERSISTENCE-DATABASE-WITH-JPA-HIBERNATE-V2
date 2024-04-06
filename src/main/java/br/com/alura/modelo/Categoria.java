package br.com.alura.modelo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CategoriaId.class)
public class Categoria {

    @Id
    private String nome;
    @Id
    private String descricao;

    public Categoria(String nome) {
        this.nome = nome;
    }
}
