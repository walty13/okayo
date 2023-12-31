package com.example.okayo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.okayo.entity.Line;

/**
 * This interface represents a repository for managing Line entities.
 * It extends the JpaRepository interface, providing CRUD operations for Line entities.
 */
public interface LineRepository extends JpaRepository<Line, Long>{

}
