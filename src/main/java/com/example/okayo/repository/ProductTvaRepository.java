package com.example.okayo.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.example.okayo.entity.ProductTva;

/**
 * This interface represents a repository for managing ProductTva entities.
 */
public interface ProductTvaRepository extends CrudRepository<ProductTva, Long> {
    /**
     * Retrieves a list of ProductTva entities by their id.
     *
     * @param id The id of the ProductTva entities to retrieve.
     * @return A list of ProductTva entities matching the given id.
     */
    List<ProductTva> findAllById(Long id);
}
