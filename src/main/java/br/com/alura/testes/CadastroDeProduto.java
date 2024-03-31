package br.com.alura.testes;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ClienteDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

import static br.com.alura.util.JPAUtil.getEntityManager;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager entityManager = getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        Produto produto = produtoDao.buscarPorId(1L);

        System.out.println(produto);

        List<Produto> produtos = produtoDao.buscarTodos();
        System.out.println("list " + produtos);

        List<Produto> produtosPorNome = produtoDao.buscarPorNome(produto.getNome());

        System.out.println("Produto por nome: " + produtosPorNome);

        List<Produto> produtosPorNomeDaCategoria = produtoDao.buscarPorNomeDaCategoria(produto.getCategoria().getNome());

        System.out.println("Produto por nome da categoria: " + produtosPorNomeDaCategoria);

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProduto(produto.getId());

        System.out.println("Produto do produto: " + precoDoProduto);
}

    public static void  cadastrarProduto() {
        EntityManager entityManager = getEntityManager();

        Categoria categoria = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("Redmi note 9 PRO", "Com memória de 258GB e RAM de 6GB", new BigDecimal("2000.00"), categoria);
        Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("5000.00"), videogames);
        Produto macbook = new Produto("Macbook", "Com memória de 258GB e RAM de 6GB", new BigDecimal("15000.00"), informatica);

        Cliente cliente = new Cliente("Gabriel", "123456");


        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(categoria);
        categoriaDao.cadastrar(videogames);
        categoriaDao.cadastrar(informatica);

        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(videogame);
        produtoDao.cadastrar(macbook);

        clienteDao.cadastrar(cliente);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
