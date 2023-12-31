package com.example.okayo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.okayo.entity.Client;
import com.example.okayo.entity.Product;
import com.example.okayo.entity.ProductTva;
import com.example.okayo.entity.Tva;
import com.example.okayo.repository.ClientRepository;
import com.example.okayo.repository.ProductRepository;
import com.example.okayo.repository.ProductTvaRepository;
import com.example.okayo.repository.TvaRepository;

import java.util.Date;

/**
 * This class represents the main application class for the Okayo application.
 * It is responsible for starting the Spring Boot application and initializing the necessary repositories.
 */
@SpringBootApplication
public class OkayoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OkayoApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private TvaRepository tvaRepository;
	@Autowired
	private ProductTvaRepository productTvaRepository;
	@Autowired
	private ClientRepository clientRepository;

	/**
	 * This method is called when the application starts.
	 * It is used to initialize the necessary repositories.
	 * 
	 * @param args the command line arguments
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		/*
		 * Uncomment the following lines to initialize the database with some data.
		 * This is useful for testing the application.
		 */

		// Tva tva1 = new Tva(0.2f, new Date(), new Date());
		// Tva tva2 = new Tva(0.055f, new Date(), new Date());
		// Tva tva3 = new Tva(0.07f, new Date(), new Date());
		// tvaRepository.save(tva1);
		// tvaRepository.save(tva2);
		// tvaRepository.save(tva3);
		
		// Product product1 = new Product("Product 1", 40000f);
		// Product product2 = new Product("Product 2", 3500f);
		// Product product3 = new Product("Product 3", 500f);
		// productRepository.save(product1);
		// productRepository.save(product2);
		// productRepository.save(product3);
		
		// productTvaRepository.save(new ProductTva(tva1, product1));
		// productTvaRepository.save(new ProductTva(tva2, product2));
		// productTvaRepository.save(new ProductTva(tva3, product3));

		// Client client = new Client("C1", "Client 1", "75016", "0695588351", "test@gmail.com");
		// clientRepository.save(client);
	}
}
