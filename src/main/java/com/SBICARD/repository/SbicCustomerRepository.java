package com.SBICARD.repository;

import com.SBICARD.entity.SbicCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SbicCustomerRepository extends JpaRepository<SbicCustomer, String> {
}
