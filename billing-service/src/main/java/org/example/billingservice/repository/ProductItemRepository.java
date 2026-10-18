package org.example.billingservice.repository;

import org.example.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
@RepositoryRestResource

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
    List<ProductItem> findByBill(Long productId);
}
