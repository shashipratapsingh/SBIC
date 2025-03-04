package com.IFA.service.impl;

import com.IFA.dto.CustomerRequestDTO;
import com.IFA.dto.CustomerResponseDTO;
import com.IFA.entity.Customer;
import com.IFA.exceptionHandler.CustomerNotFoundException;
import com.IFA.repository.CustomerRepository;
import com.IFA.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponseDTO createOrUpdateCustomer(CustomerRequestDTO request) {
        Customer customer = customerRepository.findByUniqueCustomerId(request.getUniqueCustomerId())
                .orElse(new Customer());

        customer.setUniqueCustomerId(request.getUniqueCustomerId()); // Ensure this is set
        customer.setName(request.getName());
        customer.setAge(request.getAge());
        customer.setCity(request.getCity());
        customer.setIncome(request.getIncome());
        customer.setProduct(request.getProduct());
        customer.setUniqueAccountIdentifier(request.getUniqueAccountIdentifier());
        customer.setMultiCardingFlag(request.isMultiCardingFlag());
        customer.setFeeAmount(request.getFeeAmount());

        customerRepository.save(customer);
        return new CustomerResponseDTO(customer);
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        return new CustomerResponseDTO(customer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
