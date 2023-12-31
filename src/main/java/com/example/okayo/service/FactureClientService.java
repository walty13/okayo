package com.example.okayo.service;

import java.util.List;

import com.example.okayo.entity.Client;
import com.example.okayo.entity.Facture;
import com.example.okayo.entity.FactureClient;

/**
 * This interface represents a service for managing client invoices.
 */
public interface FactureClientService {
    /**
     * Retrieves all client invoices.
     *
     * @return a list of all client invoices
     */
    List<FactureClient> getAllFactureClients();

    /**
     * Retrieves a client invoice by its ID.
     *
     * @param id the ID of the client invoice
     * @return the client invoice with the specified ID, or null if not found
     */
    FactureClient getFactureClientById(Long id);

    /**
     * Deletes a client facture line by its ref.
     *
     * @param ref the ref of the facture of the factureClient line to delete
     */
    void deleteFactureClientByRef(String code_client);

    /**
     * Saves a client invoice.
     *
     * @param client  the client associated with the invoice
     * @param facture the invoice to save
     */
    void saveFactureClient(Client client, Facture facture);

    /**
     * Checks if a client invoice already exists.
     *
     * @param code_client   the client code
     * @param facture_ref   the invoice reference
     * @return true if the client invoice already exists, false otherwise
     */
    boolean alreadyExists(String code_client, String facture_ref);
}
