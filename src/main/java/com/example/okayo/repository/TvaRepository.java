package com.example.okayo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.okayo.entity.Tva;

/**
 * This interface represents a repository for managing TVA entities.
 * It extends the JpaRepository interface, providing CRUD operations for TVA entities.
 */
public interface TvaRepository extends JpaRepository<Tva, Long> {
    
}
