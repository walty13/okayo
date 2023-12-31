package com.example.okayo.service;

import org.springframework.stereotype.Service;

import com.example.okayo.entity.Facture;
import com.example.okayo.entity.FactureLine;
import com.example.okayo.entity.Line;
import com.example.okayo.repository.FactureLineRepository;

@Service
public class FactureLineService {
    private FactureLineRepository factureLineRepository;

    public FactureLineService(FactureLineRepository factureLineRepository) {
        super();
        this.factureLineRepository = factureLineRepository;
    }

    public void deleteFactureLine(Long id) {
        factureLineRepository.deleteById(id);
    }

    public void deleteFactureLineByFactureRef(String ref) {
        for (FactureLine line : factureLineRepository.findAll()) {
            if(line.getFacture().getRef().equals(ref))
                factureLineRepository.delete(line);
        }
    }

    public void saveFactureLine(Facture facture, Line line) {
        factureLineRepository.save(new FactureLine(facture, line));
    }

    public FactureLine getFactureLineByRef(String ref) {
        for (FactureLine line : factureLineRepository.findAll()) {
            if(line.getFacture().getRef().equals(ref))
                return line;
        }
        return null;
    }
}
