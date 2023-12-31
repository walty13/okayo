package com.example.okayo.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tva")
public class Tva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valeur")
    private float valeur;

    @Column(name = "dateDebut")
    private Date debut_validite;

    @Column(name = "dateFin")
    private Date fin_validite;

    /**
     * Default constructor for Tva class.
     */
    public Tva(){}

    /**
     * Constructor for Tva class with parameters.
     * @param val The value of the Tva.
     * @param debut_validite The start date of the validity period.
     * @param fin_validite The end date of the validity period.
     */
    public Tva(float val, Date debut_validite, Date fin_validite){
        super();
        this.valeur = val;
        this.debut_validite = debut_validite;
        this.fin_validite = fin_validite;
    }
}
