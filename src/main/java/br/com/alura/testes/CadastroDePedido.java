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
        cadastrarPedido();


    }

    public static void cadastrarPedido() {
        cadastrarProduto();
        EntityManager entityManager = getEntityManager();


        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        PedidoDao pedidoDao = new PedidoDao(entityManager);

        Cliente cliente = clienteDao.buscarPorId(1L);
        Produto produto = produtoDao.buscarPorId(1L);
        Produto produto2 = produtoDao.buscarPorId(2L);
        Produto produto3 = produtoDao.buscarPorId(3L);

        Pedido pedido = new Pedido(cliente);

        ItemPedido itemPedido = new ItemPedido(10, produto, pedido);
        ItemPedido itemPedido2 = new ItemPedido(5, produto2, pedido);
        ItemPedido itemPedido3 = new ItemPedido(3, produto3, pedido);


        pedido.adicionarItem(itemPedido);
        pedido.adicionarItem(itemPedido2);
        pedido.adicionarItem(itemPedido3);


        entityManager.getTransaction().begin();
        pedidoDao.cadastrar(pedido);
        entityManager.getTransaction().commit();

//        BigDecimal valorTotal = pedidoDao.valorTotalVendido();
//        System.out.println(valorTotal);
//
//        List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
//
//        relatorio.forEach(System.out::println);

        entityManager.close();
    }

}
