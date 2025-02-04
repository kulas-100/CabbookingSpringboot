package com.project.cabbooking.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<CustomerAccount, Integer> {
    Optional<CustomerAccount> findByCdsId(String cdsId);
}
