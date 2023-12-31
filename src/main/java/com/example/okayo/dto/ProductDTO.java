package com.example.okayo.dto;

import com.example.okayo.entity.Product;

import lombok.Getter;
import lombok.Setter;

/**
    * Constructs a new ProductDTO object with the given Product.
    *
    * @param product the Product object to create the DTO from
    */
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String designation;
    private Float pu_ht;

    private TvaDTO tva;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.designation = product.getDesignation();
        this.pu_ht = product.getPu_HT();
    }
}
