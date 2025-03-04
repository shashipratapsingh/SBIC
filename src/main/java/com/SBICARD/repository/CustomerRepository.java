package com.SBICARD.repository;

import com.SBICARD.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUniqueCustomerId(String uniqueCustomerId);
}