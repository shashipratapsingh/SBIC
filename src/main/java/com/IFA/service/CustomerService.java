package com.IFA.service;

import com.IFA.dto.CustomerRequestDTO;
import com.IFA.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO createOrUpdateCustomer(CustomerRequestDTO request);
    CustomerResponseDTO getCustomerById(Long id);
    List<CustomerResponseDTO> getAllCustomers();
    void deleteCustomer(Long id);
}
