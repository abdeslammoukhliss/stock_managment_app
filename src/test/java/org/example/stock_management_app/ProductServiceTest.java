package org.example.stock_management_app;


import org.example.stock_management_app.database.DatabaseConnection;
import org.example.stock_management_app.entities.Product;
import org.example.stock_management_app.repositories.ProductRepository;
import org.example.stock_management_app.services.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductServiceImpl productService;
    @BeforeEach
    public void clearDatabase() {
        DatabaseConnection.getEntityManager().getTransaction().begin();
        DatabaseConnection.getEntityManager().createNativeQuery("DELETE FROM products").executeUpdate();
        DatabaseConnection.getEntityManager().getTransaction().commit();
    }

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl(new ProductRepository());
    }

    @Test
    void testAddProduct() {
        List<Product> products = productService.getAllProducts();
        Product product = new Product(null, "Product1", 10, 100.0);
        productService.saveProduct(product);
        List<Product> productsAfter = productService.getAllProducts();
        assertEquals(products.size()+1, productsAfter.size());
        assertEquals("Product1", products.get(0).getName());
    }

    @Test
    void testGetAllProducts() {

        Product product1 = new Product(null, "Product1", 10, 100.0);
        Product product2 = new Product(null, "Product2", 20, 200.0);

        productService.saveProduct(product1);
        productService.saveProduct(product2);

        List<Product> products = productService.getAllProducts();
        assertEquals(2, products.size());
        assertEquals("Product1", products.get(0).getName());
        assertEquals("Product2", products.get(1).getName());
    }

    @Test
    void testGetProductById() {

        Product product = productService.saveProduct( new Product(null, "Product1", 10, 100.0));

        Product retrievedProduct = productService.getProductById(product.getId());
        assertTrue(retrievedProduct!=null);
        assertEquals("Product1", retrievedProduct.getName());
    }

    @Test
    void testDeleteProduct() {
        Product product = productService.saveProduct( new Product(null, "Product1", 10, 100.0));


        productService.deleteProduct(product.getId());
        List<Product> products = productService.getAllProducts();
        assertTrue(products.isEmpty());
    }
}
