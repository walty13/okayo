package com.example.okayo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.okayo.entity.Product;

/**
 * This interface represents a repository for managing Product entities.
 * It extends the JpaRepository interface, providing CRUD operations for Product entities.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
