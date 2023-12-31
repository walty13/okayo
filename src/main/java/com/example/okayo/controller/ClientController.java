package com.example.okayo.controller;

import org.springframework.stereotype.Controller;

import com.example.okayo.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        super();
        this.clientService = clientService;
    }
    
    @GetMapping("/clients")
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }
    
}
