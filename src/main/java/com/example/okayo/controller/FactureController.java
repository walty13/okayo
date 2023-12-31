package com.example.okayo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.okayo.entity.Line;
import com.example.okayo.service.FactureClientService;
import com.example.okayo.service.FactureLineService;
import com.example.okayo.service.LineService;

import org.springframework.web.bind.annotation.*;


@Controller
public class FactureController {
    private FactureClientService factureClientService;
    private LineService lineService;

    /**
     * Constructs a new FactureController with the specified FactureClientService.
     * 
     * @param factureClientService the FactureClientService to be used
     */
    public FactureController(FactureClientService factureClientService, FactureLineService factureLineService) {
        super();
        this.factureClientService = factureClientService;
        this.factureClientService = factureClientService;
    }

    /**
     * Retrieves the factures and adds them to the model.
     * 
     * @param model the model to add the factures to
     * @return the name of the view to render
     */
    @GetMapping("/factures")
    public String getFactures(Model model) {
        model.addAttribute("factures", factureClientService.getAllFactureClients());
        return "factures";
    }
     
    /**
     * Deletes a facture with the given reference.
     * 
     * @param ref the reference of the facture to delete
     * @return the name of the view to render
     */
    @GetMapping("/factures/{ref}")
    public String deleteFacture(@PathVariable String ref) {
        factureClientService.deleteFactureClientByRef(ref);
        for (Line line : lineService.getAllLinesByRef(ref)) {
            lineService.deleteLine(line.getId());
        }
        return "redirect:/factures";
    }
}
