package com.example.okayo.service;

import java.util.List;
import com.example.okayo.entity.Facture;

/**
 * This interface represents a service for managing factures.
 */
public interface FactureService {
    /**
     * Retrieves all factures.
     *
     * @return a list of all factures
     */
    List<Facture> getAllFactures();

    /**
     * Retrieves a facture by its reference.
     *
     * @param ref the reference of the facture
     * @return the facture with the specified reference, or null if not found
     */
    Facture getFactureById(String ref);

    /**
     * Saves a facture.
     *
     * @param facture the facture to be saved
     * @return the saved facture
     */
    Facture saveFacture(Facture facture);

    /**
     * Deletes a facture by its reference.
     *
     * @param ref the reference of the facture to be deleted
     */
    void deleteFacture(String ref);
}
