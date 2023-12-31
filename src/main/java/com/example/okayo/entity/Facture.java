package com.example.okayo.entity;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "facture")
public class Facture {
    @Id
    private String ref;

    @Column(name = "date_echeance")
    private Date date_echeance;

    @Column(name = "date_facture")
    private Date date_facture;

    @Column(name = "total_ht")
    private double total_ht;

    @Column(name = "total_ttc")
    private double total_ttc;

    /**
     * Default constructor for Facture class.
     */
    public Facture() {}

    /**
     * Constructor for Facture class with parameters.
     *
     * @param ref The reference of the facture.
     * @param date_echeance The due date of the facture.
     * @param date_facture The date of the facture.
     * @param total_ht The total amount without taxes.
     * @param total_ttc The total amount with taxes.
     */
    public Facture(String ref, Date date_echeance, Date date_facture, double total_ht, double total_ttc) {
        super();
        this.ref = ref;
        this.date_echeance = date_echeance;
        this.date_facture = date_facture;
        this.total_ht = total_ht;
        this.total_ttc = total_ttc;
    }
}
