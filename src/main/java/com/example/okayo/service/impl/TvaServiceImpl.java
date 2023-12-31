package com.example.okayo.service.impl;

import java.util.List;

import com.example.okayo.entity.Tva;
import com.example.okayo.repository.TvaRepository;
import com.example.okayo.service.TvaService;

import org.springframework.stereotype.Service;

/* 
 * This class implements the TvaService interface and provides the implementation for the service methods.
 */
@Service
public class TvaServiceImpl implements TvaService{
    private TvaRepository tvaRepository;

    /**
     * Constructs a new TvaServiceImpl with the specified TvaRepository.
     * 
     * @param tvaRepository the repository used for accessing Tva data
     */
    public TvaServiceImpl(TvaRepository tvaRepository) {
        super();
        this.tvaRepository = tvaRepository;
    }

    @Override
    public List<Tva> getAllTva() {
        return tvaRepository.findAll();
    }

    @Override
    public Tva getTvaByTva(Float tva) {
        for (Tva tva_instance : getAllTva()) {
            if(tva_instance.getValeur() == tva){
                return tva_instance;
            }
        }
        return null;
    }
}
