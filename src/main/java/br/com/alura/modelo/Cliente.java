package br.com.alura.modelo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldNameConstants
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private DadosPessoais dadosPessoais;

    public Cliente(String nome, String cpf) {
        this.dadosPessoais = new DadosPessoais(nome, cpf);
    }

    public String getNome() {
        return this.dadosPessoais.getNome();
    }
}
