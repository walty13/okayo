package com.example.okayo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.okayo.entity.FactureLine;

public interface FactureLineRepository extends JpaRepository<FactureLine, Long> {
    
}
