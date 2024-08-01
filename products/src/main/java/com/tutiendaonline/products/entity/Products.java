package com.tutiendaonline.products.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private Double price;
    private int stock;

    @OneToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
