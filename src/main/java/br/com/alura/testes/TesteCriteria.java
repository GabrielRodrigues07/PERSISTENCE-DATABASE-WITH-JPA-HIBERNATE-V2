package br.com.alura.testes;

import br.com.alura.dao.ProdutoDao;
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
        entityManager.close();

    }
}
