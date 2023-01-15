package com.example.onlinestore.OnlineStore.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT s FROM Product s WHERE s.productName = ?1")
    Optional<Product> findProductByName(String productName);
}
