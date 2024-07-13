package org.example.stock_management_app.database;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DatabaseConnection {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("DB");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public static void closeEntityManager() {
        if (entityManager != null) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
