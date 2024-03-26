package br.com.alura.testes;

import br.com.alura.dao.ClienteDao;
import br.com.alura.dao.PedidoDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.ItemPedido;
import br.com.alura.modelo.Pedido;
import br.com.alura.modelo.Produto;
import jakarta.persistence.EntityManager;

import static br.com.alura.testes.CadastroDeProduto.cadastrarProduto;
import static br.com.alura.util.JPAUtil.getEntityManager;

public class CadastroDePedido {

    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager entityManager = getEntityManager();


        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        PedidoDao pedidoDao = new PedidoDao(entityManager);

        Cliente cliente = clienteDao.buscarPorId(1L);
        Produto produto = produtoDao.buscarPorId(1L);

        Pedido pedido = new Pedido(cliente);

        ItemPedido itemPedido = new ItemPedido(10, produto, pedido);


        pedido.adicionarItem(itemPedido);


        entityManager.getTransaction().begin();
        pedidoDao.cadastrar(pedido);
        Pedido pedido1 = pedidoDao.buscarPorId(1L);
        System.out.println("teste" + pedido1);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
