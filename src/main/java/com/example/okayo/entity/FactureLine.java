package com.example.okayo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "facture_line")
public class FactureLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facture_ref", nullable = false, referencedColumnName = "ref")
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "line_id", nullable = false, referencedColumnName = "id")
    private Line line;

    public FactureLine() {
    }

    public FactureLine(Facture facture, Line line) {
        super();
        this.facture = facture;
        this.line = line;
    }
}
