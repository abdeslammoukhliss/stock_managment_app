package org.example.stock_management_app.services;


import org.example.stock_management_app.entities.Product;
import org.example.stock_management_app.repositories.IProductRepository;
import org.example.stock_management_app.repositories.ProductRepository;


import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
