package com.example.okayo.service;

import java.util.List;
import com.example.okayo.entity.Tva;

/**
 * This interface represents a service for managing TVA (Taxe sur la Valeur Ajoutée) entities.
 */
public interface TvaService {
    /**
     * Retrieves all TVA entities.
     *
     * @return a list of all TVA entities
     */
    public List<Tva> getAllTva();

    /**
     * Retrieves a TVA entity by its TVA value.
     *
     * @param tva the TVA value to search for
     * @return the TVA entity with the specified TVA value, or null if not found
     */
    public Tva getTvaByTva(Float tva);
}
