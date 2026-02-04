package com.sba301.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;
    @Column(name = "product_name", nullable = false, length = 255)
    private String name;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "description", length = 255)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String name, double price, String description, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }
}
