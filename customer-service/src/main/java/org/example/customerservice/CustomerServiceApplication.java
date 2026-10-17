package org.example.customerservice;

import org.example.customerservice.entites.Customer;
import org.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
        customerRepository.save(Customer.builder()
                .name("Mohammed").email("med@gmail.com").build());
        customerRepository.save(Customer.builder()
                    .name("Imane").email("imane@gmail.com").build());
        customerRepository.save(Customer.builder()
                    .name("Yassine").email("yassine@gmail.com").build());
        };
    }
}
