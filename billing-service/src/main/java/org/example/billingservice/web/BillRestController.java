package org.example.billingservice.web;

import org.example.billingservice.entities.Bill;
import org.example.billingservice.feign.CustomerServiceRestClient;
import org.example.billingservice.feign.InventoryServiceRestClient;
import org.example.billingservice.model.Customer;
import org.example.billingservice.repository.BillRepository;
import org.example.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient inventoryServiceRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBillById( @PathVariable Long id){
            Bill bill=billRepository.findById(id).get();
        Customer customer =
                customerServiceRestClient.findCustomerById(bill.getCustomerId());
            bill.setCustomer(customer);
            bill.getProductItems().forEach(pi->{
                pi.setProduct(
                        inventoryServiceRestClient.getProduct(pi.getProductId()));

            });
            return bill;
        }
    }

