package com.example.okayo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a relationship between a product and a TVA (taxe sur la valeur ajoutée).
 */
@Getter
@Setter
@Entity
@Table(name = "product_tva")
public class ProductTva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_tva", referencedColumnName = "id")
    @ManyToOne
    private Tva tva;

    @JoinColumn(name = "id_prod", referencedColumnName = "id")
    @ManyToOne
    private Product product;

    /**
     * Default constructor for the ProductTva class.
     */
    public ProductTva() {
    }

    /**
     * Constructor for the ProductTva class.
     * 
     * @param id        the ID of the product-TVA relationship
     * @param tva       the TVA (tax) of the product
     * @param product   the product
     */
    public ProductTva(Tva tva, Product product) {
        super();
        this.tva = tva;
        this.product = product;
    }
}

