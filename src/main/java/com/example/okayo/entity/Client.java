package com.example.okayo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    private String code_client;

    @Column(name = "Nom", nullable = false)
    private String nom;
    
    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "Email", nullable = false)
    private String email;

    /**
     * Default constructor for the Client class.
     */
    public Client() {
    }

    /**
     * Constructor for the Client class.
     * 
     * @param code_client   the ID of the client
     * @param nom       the name of the client
     * @param adresse   the address of the client
     * @param telephone the telephone number of the client
     * @param email     the email address of the client
     */
    public Client(String code_client, String nom, String adresse, String telephone, String email) {
        super();
        this.code_client = code_client;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }
}