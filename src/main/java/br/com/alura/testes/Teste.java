package br.com.alura.testes;

import br.com.alura.dao.PedidoDao;
import br.com.alura.modelo.Pedido;
import jakarta.persistence.EntityManager;

import static br.com.alura.testes.CadastroDePedido.cadastrarPedido;
import static br.com.alura.util.JPAUtil.getEntityManager;

public class Teste {

    public static void main(String[] args) {
        cadastrarPedido();

        EntityManager entityManager = getEntityManager();
        PedidoDao pedidoDao = new PedidoDao(entityManager);


        Pedido pedido = pedidoDao.buscarPorId(1L);
        System.out.println("---" + pedido);
        System.out.println(pedido.getItens().get(0).getProduto());
        entityManager.close();

    }
}
