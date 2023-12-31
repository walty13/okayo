package com.example.okayo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.okayo.entity.Client;
import com.example.okayo.entity.Facture;
import com.example.okayo.entity.FactureClient;
import com.example.okayo.repository.FactureClientRepository;
import com.example.okayo.service.FactureClientService;

/**
 * This class implements the FactureClientService interface and provides the implementation for the service methods.
 */
@Service
public class FactureClientServiceImpl implements FactureClientService {
    private FactureClientRepository factureClientRepository;

    /**
     * Constructs a new FactureClientServiceImpl with the specified FactureClientRepository.
     * 
     * @param factureClientRepository the repository used for accessing FactureClient data
     */
    public FactureClientServiceImpl(FactureClientRepository factureClientRepository) {
        super();
        this.factureClientRepository = factureClientRepository;
    }

    @Override
    public List<FactureClient> getAllFactureClients() {
        return factureClientRepository.findAll();
    }

    @Override
    public FactureClient getFactureClientById(Long id) {
        return factureClientRepository.findById(id).get();
    }

    @Override
    public void saveFactureClient(Client client, Facture facture) {
        factureClientRepository.save(new FactureClient(client, facture));
    }

    @Override
    public void deleteFactureClientByRef(String ref) {
        List<FactureClient> factureClients = factureClientRepository.findAll();
        for(FactureClient factureClient : factureClients){
            if(factureClient.getFacture().getRef().equals(ref)){
                factureClientRepository.deleteById(factureClient.getId());
            }
        }
    }

    @Override
    public boolean alreadyExists(String code_client, String facture_ref) {
        List<FactureClient> factureClients = factureClientRepository.findAll();
        for(FactureClient factureClient : factureClients){
            if(factureClient.getClient().getCode_client().equals(code_client) 
                    && factureClient.getFacture().getRef().equals(facture_ref)){
                return true;
            }
        }
        return false;
    }
}
