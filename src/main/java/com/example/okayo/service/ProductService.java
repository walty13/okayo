package com.example.okayo.service;

import java.util.List;

import com.example.okayo.dto.ProductDTO;
import com.example.okayo.entity.Product;

/**
 * This interface represents a service for managing products.
 */
public interface ProductService {
    /**
     * Retrieves all products.
     *
     * @return a list of ProductDTO objects representing all products
     */
    List<ProductDTO> getAllProducts();

    /**
     * Retrieves a product by its ID.
     *
     * @param id        the ID of the product
     * @param withTva   a flag indicating whether to include TVA (tax) information
     * @return a ProductDTO object representing the product
     */
    ProductDTO getProductById(Long id, boolean withTva);

    /**
     * Saves a new product.
     *
     * @param productDTO    the ProductDTO object representing the product to be saved
     * @return the saved Product object
     */
    Product saveProduct(ProductDTO productDTO);
    
    /**
     * Deletes a product by its ID.
     *
     * @param id    the ID of the product to be deleted
     */
    void deleteProduct(long id);
}
