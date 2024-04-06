package br.com.alura.dao;

import br.com.alura.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ProdutoDao {

    private final EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto) {
        this.entityManager.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        return entityManager.createQuery("SELECT p FROM Produto p WHERE p.nome = :nome", Produto.class)
                .setParameter(Produto.Fields.nome, nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        return entityManager.createNamedQuery("Produto.produtoPorCategoria", Produto.class)
                .setParameter(Produto.Fields.nome, nome)
                .getResultList();
    }

    public BigDecimal buscarPrecoDoProduto(Long id) {
        return entityManager.createQuery("SELECT p.preco FROM Produto p WHERE p.id = :id", BigDecimal.class)
                .setParameter(Produto.Fields.id, id)
                .getSingleResult();
    }

    public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
        String jpql = "SELECT p FROM Produto p WHERE 1=1 ";
        if (Objects.nonNull(nome) && !nome.isBlank()) {
            jpql = "AND p.nome =:nome";
        }
        if (Objects.nonNull(preco)) {
            jpql = "AND p.preco =:preco";
        }
        if (Objects.nonNull(dataCadastro)) {
            jpql = "AND p.dataCadastro =:dataCadastro";
        }
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);

        if (Objects.nonNull(nome) && !nome.isBlank()) {
            query.setParameter(Produto.Fields.nome, nome);
        }
        if (Objects.nonNull(nome) && !nome.isBlank()) {
            query.setParameter(Produto.Fields.preco, preco);
        }
        if (Objects.nonNull(nome) && !nome.isBlank()) {
            query.setParameter(Produto.Fields.dataCadastro, dataCadastro);
        }

        return query.getResultList();
    }
}
