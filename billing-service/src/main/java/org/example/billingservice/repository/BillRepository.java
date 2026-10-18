package org.example.billingservice.repository;

import org.example.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource

public interface BillRepository extends JpaRepository<Bill,Long> {

}
