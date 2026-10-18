
package org.example.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryServiceRestClient {

    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "inv-service", fallbackMethod = "getDefaultProduct")
    Product getProduct(@PathVariable("id") String id);

    default Product getDefaultProduct(String id, Exception e) {
        return Product.builder()
                .id(Long.valueOf(id))
                .name("default")
                .build();
    }
}