package br.com.alura.dao;

import br.com.alura.modelo.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public void remover(Categoria categoria) {
        entityManager.merge(categoria);
        this.entityManager.remove(categoria);
    }
}
