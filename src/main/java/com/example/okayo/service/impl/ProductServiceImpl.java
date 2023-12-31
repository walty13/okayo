package com.example.okayo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.okayo.dto.ProductDTO;
import com.example.okayo.dto.TvaDTO;
import com.example.okayo.entity.Product;
import com.example.okayo.entity.ProductTva;
import com.example.okayo.service.ProductService;
import com.example.okayo.repository.ProductRepository;
import com.example.okayo.repository.ProductTvaRepository;

/*
 * This class implements the ProductService interface and provides the implementation for the service methods.
 */
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private ProductTvaRepository productTvaRepository;

    /**
     * Constructs a new ProductServiceImpl with the specified ProductRepository.
     * 
     * @param productRepository the repository used for accessing Product data
     */
    public ProductServiceImpl(ProductRepository productRepository, ProductTvaRepository productTvaRepository) {
        super();
        this.productRepository = productRepository;
        this.productTvaRepository = productTvaRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>(); // Initialize the list
        for(Product product : products) {
            ProductDTO productDTO = new ProductDTO(product);
            List<ProductTva> productTvas = productTvaRepository.findAllById(productDTO.getId());
            TvaDTO tvaDTO = new TvaDTO(productTvas.get(0).getTva());
            productDTO.setTva(tvaDTO);
            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    public ProductDTO getProductById(Long id, boolean withTva) {
        if(withTva){
            Product product = productRepository.findById(id).orElse(null);
            List<ProductTva> productTvas = productTvaRepository.findAllById(id);
            ProductDTO productDTO = new ProductDTO(product);
            TvaDTO tvaDTO = new TvaDTO(productTvas.get(0).getTva());
            productDTO.setTva(tvaDTO);
            return productDTO;
        } else {
            return new ProductDTO(productRepository.findById(id).orElse(null));
        }
    }
    
    public Product saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setDesignation(productDTO.getDesignation());
        product.setPu_HT(productDTO.getPu_ht());
        product.setId(productDTO.getId());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
