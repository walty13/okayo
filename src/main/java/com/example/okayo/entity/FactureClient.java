package com.example.okayo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "facture_client")
public class FactureClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "code_client", referencedColumnName = "code_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "ref_facture", referencedColumnName = "ref")
    private Facture facture;

    /**
     * Default constructor for FactureClient.
     */
    public FactureClient() {
    }

    /**
     * Constructor for FactureClient with client and facture parameters.
     *
     * @param client  The client associated with the facture.
     * @param facture The facture associated with the client.
     */
    public FactureClient(Client client, Facture facture) {
        this.client = client;
        this.facture = facture;
    }
}
