package com.example.onlinestore.OnlineStore.product;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        LOGGER.info("getAllProducts was called");
        return productRepository.findAll();
    }

    Product getProduct(Long id){
        return productRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalStateException(

                                "product with id" + id + "not found"));
    }


    public void addNewProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findProductByName(product.getProductName());
        if (optionalProduct.isPresent()){
            LOGGER.error("error");
            throw new IllegalStateException("productName taken");
        }
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists){
            throw  new IllegalStateException("product with id " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, String productName, String description) {
        LOGGER.info("updated product successfully");
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException(
                        "product with id"+ productId + "does not exist"));
        if (productName != null && productName.length() > 0 &&
                !Objects.equals(product.getProductName(), productName)){
            product.setProductName(productName);
        }
        if (description != null && description.length() > 0 &&
                !Objects.equals(product.getDescription(), description)){
            product.setDescription(description);
        }
    }
}
