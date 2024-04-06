package br.com.alura.testes;

import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.CategoriaId;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

import static br.com.alura.testes.CadastroDeProduto.cadastrarProduto;
import static br.com.alura.util.JPAUtil.getEntityManager;

public class TesteCriteria {

    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager entityManager = getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        produtoDao.buscarPorParametrosComCriteria("PS5", null, null);
        produtoDao.buscarPorParametros(null, null, LocalDate.now());

        Categoria celulares = entityManager.find(Categoria.class, CategoriaId.builder()
                .nome("CELULARES")
                .descricao("TESTE")
                .build());

        System.out.println(celulares);

        entityManager.close();

    }
}
