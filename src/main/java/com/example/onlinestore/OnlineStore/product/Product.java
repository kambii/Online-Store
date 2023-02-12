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
    private String description;

    public Product() {
    }

    public Product(String productName, String description) {
        this.productName = productName;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
