package br.com.alura.modelo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedidos")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldNameConstants
@NoArgsConstructor
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    public ItemPedido(Integer quantidade, Produto produto, Pedido pedido) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.precoUnitario = produto.getPreco();
        this.pedido = pedido;
    }

    public BigDecimal getValor() {
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }
}
