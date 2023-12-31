package com.example.okayo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "pu_ht", nullable = false)
    private Float pu_HT;

    /**
     * Default constructor for the Product class.
     */
    public Product() {}

    /**
     * Constructor for the Product class.
     * 
     * @param designation the designation of the product
     * @param puHT the price per unit (HT) of the product
     */
    public Product(String designation, Float puHT) {
        super();
        this.designation = designation;
        this.pu_HT = puHT;
    }
}
