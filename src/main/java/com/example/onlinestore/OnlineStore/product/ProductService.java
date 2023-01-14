package com.example.onlinestore.OnlineStore.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }


    public void addNewProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findProductByName(product.getProductName());
        if (optionalProduct.isPresent()){
            throw new IllegalStateException("productName taken");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists){
            throw new IllegalStateException("product with id" + productId + "does not exist");
        }
        productRepository.deleteById(productId);
    }

    public void updateProduct(Long productId, String productName) {

    }
}
