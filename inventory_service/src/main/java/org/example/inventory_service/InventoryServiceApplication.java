package org.example.inventory_service;

import org.example.inventory_service.entities.Product;
import org.example.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository)
    {
        return args -> {
            productRepository.save(Product.builder()

                            .name("Computer")
                            .price(34000)
                            .quantity(12)
                            .build());
            productRepository.save(Product.builder()

                    .name("Printer")
                    .price(1200)
                    .quantity(10)
                    .build());
            productRepository.save(Product.builder()

                    .name("Smart Phone")
                    .price(11000)
                    .quantity(6)
                    .build());

        };
    }
}

