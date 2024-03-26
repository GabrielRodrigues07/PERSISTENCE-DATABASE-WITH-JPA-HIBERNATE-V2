package br.com.alura.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
@Data
@FieldNameConstants
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valorTotal;
    private LocalDate date = LocalDate.now();

    @ManyToOne
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }
}
