package com.example.okayo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.okayo.entity.Client;
import com.example.okayo.repository.ClientRepository;
import com.example.okayo.service.ClientService;

/**
 * This class implements the ClientService interface and provides the implementation for the service methods.
 */
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    /**
     * Constructor injection
     * @param clientRepository
     */
    public ClientServiceImpl(ClientRepository clientRepository) {
        super();
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
    @Override
    public Client getClientById(String code_client) {
        return clientRepository.findById(code_client).get();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
