package com.example.okayo.service;

import java.util.List;
import com.example.okayo.entity.Client;

/**
 * This interface represents a service for managing clients.
 */
public interface ClientService {
    /**
     * Retrieves a list of all clients.
     *
     * @return a list of all clients
     */
    List<Client> getAllClients();

    /**
     * Retrieves a client by their ID.
     *
     * @param code_client the ID of the client
     * @return the client with the specified ID, or null if not found
     */
    Client getClientById(String code_client);
    
    /**
     * Saves a client.
     *
     * @param client the client to be saved
     * @return the saved client
     */
    Client saveClient(Client client);
}