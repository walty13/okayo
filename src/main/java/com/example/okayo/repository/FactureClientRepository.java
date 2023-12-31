package com.example.okayo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.okayo.entity.FactureClient;

/**
 * This interface represents a repository for managing FactureClient entities.
 * It extends the JpaRepository interface, providing CRUD operations for FactureClient entities.
 */
public interface FactureClientRepository extends JpaRepository<FactureClient, Long> {
    
}
