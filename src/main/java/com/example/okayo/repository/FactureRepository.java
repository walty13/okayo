package com.example.okayo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.okayo.entity.Facture;

/**
 * This interface represents a repository for managing Facture entities.
 * It extends the JpaRepository interface, providing CRUD operations for Facture objects.
 */
public interface FactureRepository extends JpaRepository<Facture, String> {
    
}
