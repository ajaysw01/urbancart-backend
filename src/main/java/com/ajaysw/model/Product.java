package com.ajaysw.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank
    @Size(min = 3, message = "Product name must contain atleast 3 character.")
    private String productName;

    @NotBlank
    @Size(min = 10, message = "Product name must contain atleast 10character.")
    private String description;

    private String image;

    private Integer quantity;

    private double price;

    private double discount;

    private double specialPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
