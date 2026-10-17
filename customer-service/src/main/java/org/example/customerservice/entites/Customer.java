package org.example.customerservice.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
   @Id
   @GeneratedValue
    private Long id;
    private String name;
    private String email;
}
