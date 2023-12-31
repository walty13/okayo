package com.example.okayo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "line")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "pu_ht")
    private double pu_ht;

    @Column(name = "tva")
    private Float tva;

    @Column(name = "quantite")
    private int quantite;

    @Column(name = "ref", nullable = false)
    private String ref;

    /**
     * Default constructor for the Line class.
     */
    public Line() {}

    /**
     * Constructor for the Line class.
     * 
     * @param designation the designation of the line
     * @param pu_ht the unit price excluding tax of the line
     * @param tva the tax rate of the line
     * @param quantite the quantity of the line
     * @param ref the reference of the line
     */
    public Line(String designation, double pu_ht, Float tva, int quantite, String ref) {
        super();
        this.designation = designation;
        this.pu_ht = pu_ht;
        this.tva = tva;
        this.quantite = quantite;
        this.ref = ref;
    }
}
