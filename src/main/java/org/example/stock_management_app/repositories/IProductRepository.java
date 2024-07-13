package org.example.stock_management_app.repositories;

import org.example.stock_management_app.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    void deleteById(Long id);
}
