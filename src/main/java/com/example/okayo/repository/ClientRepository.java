package com.example.okayo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.okayo.entity.Client;

/**
 * This interface represents a repository for managing clients.
 */
public interface ClientRepository extends JpaRepository<Client, String> {
    
}
