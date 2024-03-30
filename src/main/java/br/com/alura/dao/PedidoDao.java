package br.com.alura.dao;

import br.com.alura.modelo.Pedido;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class PedidoDao {

    private final EntityManager entityManager;

    public PedidoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Pedido pedido) {
        this.entityManager.persist(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return entityManager.find(Pedido.class, id);
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";

        return entityManager.createQuery(jpql, BigDecimal.class)
                .getSingleResult();

    }

}
