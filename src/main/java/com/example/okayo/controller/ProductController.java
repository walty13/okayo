package com.example.okayo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.okayo.dto.ProductDTO;
import com.example.okayo.entity.Facture;
import com.example.okayo.entity.FactureLine;
import com.example.okayo.entity.Line;
import com.example.okayo.service.*;

/**
 * The ProductController class handles the HTTP requests related to products.
 */
@Controller
public class ProductController {
    private ProductService productService;
    private LineService lineService;
    private FactureService factureService;
    private FactureClientService factureClientService;
    private ClientService clientService;
    private FactureLineService factureLineService;

    public ProductController(
        ProductService productService, 
        LineService lineService, 
        FactureService factureService,
        FactureClientService factureClientService,
        ClientService clientService,
        FactureLineService factureLineService) {

        super();
        this.productService = productService;
        this.lineService = lineService;
        this.factureService = factureService;
        this.factureClientService = factureClientService;
        this.clientService = clientService;
        this.factureLineService = factureLineService;
    }

    /**
        * Retrieves a list of products and adds them to the model.
        * 
        * @param model the model to add the products to
        * @return the name of the view to render
        */
    @GetMapping("/products")
    public String getProducts(Model model) {
        List<ProductDTO> productDTOs = productService.getAllProducts();
        model.addAttribute("products", productDTOs);
        return "products";
    }

    /**
        * Saves a product with the given ID and reference.
        * 
        * @param id the ID of the product
        * @param ref the reference of the product
        * @return the redirect URL
        */
    @GetMapping("/products/add/{id}")
    public String saveProduct(@PathVariable Long id, @RequestParam(value = "ref", required = true) String ref) {
        ProductDTO product = productService.getProductById(id, true);
        List<Line> lines = lineService.getAllLines();
        if(lines.size() > 0){
            for(Line line : lines){
                if(line.getDesignation().equals(product.getDesignation()) && line.getRef().equals(ref)){
                    line.setQuantite(line.getQuantite() + 1);
                    System.out.println("Saving line " + line.getDesignation() + " " + line.getQuantite());
                    lineService.saveOrUpdateLine(line);
                    return "redirect:/products";
                }
            }
            Line newLine = new Line();
            newLine.setDesignation(product.getDesignation());
            newLine.setPu_ht(product.getPu_ht());
            newLine.setQuantite(1);
            newLine.setTva(product.getTva().getValeur());
            newLine.setRef(ref);
            lineService.saveOrUpdateLine(newLine);

        }else{
            Line newLine = new Line();
            newLine.setDesignation(product.getDesignation());
            newLine.setPu_ht(product.getPu_ht());
            newLine.setQuantite(1);
            newLine.setTva(product.getTva().getValeur());
            newLine.setRef(ref);
            lineService.saveOrUpdateLine(newLine);
        }
        return "redirect:/products";
    }

    /**
        * Deletes a product by its ID and reference.
        * 
        * @param id the ID of the product to delete
        * @param ref the reference of the product to delete
        * @return a redirect to the "/products" page
        */
    @GetMapping("/products/{id}")
    public String deleteProductById(@PathVariable Long id, @RequestParam(value = "ref", required = true) String ref) {
        ProductDTO product = productService.getProductById(id, true);
        List<Line> lines = lineService.getAllLines();
        if(lines != null){
            for(Line line : lines){
                System.out.println(line.getDesignation() + " " + product.getDesignation());
                if(line.getDesignation().equals(product.getDesignation()) && line.getRef().equals(ref)){
                    System.out.println("Line found");
                    line.setQuantite(line.getQuantite() - 1); 
                    if(line.getQuantite() == 0){
                        lineService.deleteLine(line.getId());
                    } else {
                        lineService.saveOrUpdateLine(line);
                    }
                    return "redirect:/products";
                }
            }
        }
        return "redirect:/products";
    }
    
    /**
        * Creates a facture for a given reference and client code.
        * 
        * @param ref The reference of the facture.
        * @param code_client The client code.
        * @return The redirect URL after creating the facture.
        */
    @GetMapping("/products/submit/{ref}")
    public String createFacture(
        @PathVariable String ref,
        @RequestParam(value = "code_client", required = true) String code_client) {

        // Check if the facture already exists
        if(ref == null || code_client == null || factureClientService.alreadyExists(code_client, ref)){
            System.out.println("Facture already exists");
            return "redirect:/products";
        }

        List<Line> lines = lineService.getAllLinesByRef(ref);
        if(lines != null){
            // Create the facture
            Facture facture = new Facture();
            facture.setRef(ref);
            facture.setDate_facture(new Date());
            facture.setDate_echeance(Date.from(new Date().toInstant().plusSeconds(2592000)));
            double total_ht = 0, total_ttc = 0;

            for(Line line : lines){
                if(line.getRef().equals(ref)){
                    // Calculate the total_ht and total_ttc
                    total_ht += line.getQuantite() * line.getPu_ht();
                    total_ttc += line.getQuantite() * line.getPu_ht() * (1 + line.getTva());
                }
            }
            facture.setTotal_ht(total_ht);
            facture.setTotal_ttc(total_ttc);
            // Save the facture
            factureService.saveFacture(facture);
            // Save the factureClient
            factureClientService.saveFactureClient(clientService.getClientById(code_client), facture);

            // Save all factureLines
            for(Line line : lines){
                if(line.getRef().equals(ref)){
                    factureLineService.saveFactureLine(facture, line);
                }
            }
        }

        return "redirect:/factures";
    }
}
