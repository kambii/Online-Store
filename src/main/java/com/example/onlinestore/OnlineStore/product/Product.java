package com.example.onlinestore.OnlineStore.product;

import jakarta.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String productName;

    public Product() {
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }
}
