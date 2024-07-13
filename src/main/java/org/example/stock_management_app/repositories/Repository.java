package org.example.stock_management_app.repositories;

import org.example.stock_management_app.database.DatabaseConnection;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;


import java.lang.reflect.ParameterizedType;
import java.util.List;

public class Repository<T, K> {

    private final EntityManager entityManager= DatabaseConnection.getEntityManager();

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public Repository() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public T findById(K id) {
        return entityManager.find(entityClass, id);
    }

    public void deleteById(K id) {
        entityManager.getTransaction().begin();
        T entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
        entityManager.getTransaction().commit();
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }
}
