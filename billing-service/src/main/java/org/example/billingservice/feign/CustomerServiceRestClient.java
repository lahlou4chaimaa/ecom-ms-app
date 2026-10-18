
package org.example.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerServiceRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="customer-service", fallbackMethod="getDefaultCustomer")
    Customer findCustomerById(@PathVariable("id") Long id);

    default Customer getDefaultCustomer(Long id , Exception exception)
    { exception.printStackTrace();
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("default");
        customer.setEmail("default@gmail.com");
        return customer;
    }
}
