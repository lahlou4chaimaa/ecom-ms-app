package org.example.billingservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.billingservice.entities.Bill;
import org.example.billingservice.entities.ProductItem;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String name ;
    private double price;
    private int quantity;
    @ManyToOne
    private Bill bill;
    @Transient
    private Product product;
}
