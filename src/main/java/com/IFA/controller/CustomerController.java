package com.IFA.controller;

import com.IFA.dto.CustomerRequestDTO;
import com.IFA.dto.CustomerResponseDTO;
import com.IFA.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO request) {
        return ResponseEntity.ok(customerService.createOrUpdateCustomer(request));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
