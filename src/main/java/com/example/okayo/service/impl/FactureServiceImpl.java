package com.example.okayo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.okayo.entity.Facture;
import com.example.okayo.repository.FactureRepository;
import com.example.okayo.service.FactureService;

/**
 * This class implements the FactureService interface and provides the implementation for the service methods.
 */
@Service
public class FactureServiceImpl implements FactureService {
    private FactureRepository factureRepository;

    /**
     * Constructs a new FactureServiceImpl with the specified FactureRepository.
     * 
     * @param factureRepository the repository used for accessing Facture data
     */
    public FactureServiceImpl(FactureRepository factureRepository) {
        super();
        this.factureRepository = factureRepository;
    }

    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Facture getFactureById(String ref) {
        return factureRepository.findById(ref).orElse(null);
    }

    @Override
    public Facture saveFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public void deleteFacture(String ref) {
        factureRepository.deleteById(ref);
    }
}
