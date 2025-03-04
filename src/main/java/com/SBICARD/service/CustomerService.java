package com.SBICARD.service;

import com.SBICARD.dto.CustomerRequestDTO;
import com.SBICARD.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO createOrUpdateCustomer(CustomerRequestDTO request);
    CustomerResponseDTO getCustomerById(Long id);
    List<CustomerResponseDTO> getAllCustomers();
    void deleteCustomer(Long id);
}
