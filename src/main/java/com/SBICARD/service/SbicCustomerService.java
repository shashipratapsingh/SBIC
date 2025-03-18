package com.SBICARD.service;

import com.SBICARD.entity.SbicCustomer;
import com.SBICARD.repository.SbicCustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SbicCustomerService {
    private final SbicCustomerRepository sbicCustomerRepository;

    public SbicCustomerService(SbicCustomerRepository sbicCustomerRepository) {
        this.sbicCustomerRepository = sbicCustomerRepository;
    }

    public SbicCustomer createOrUpdateProfile(SbicCustomer sbicCustomer) {
        return sbicCustomerRepository.save(sbicCustomer);
    }

    public SbicCustomer getCustomerProfile(String uniqueId) {
        return sbicCustomerRepository.findById(uniqueId).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public String issueECard(String uniqueId) {
        Optional<SbicCustomer> customer = sbicCustomerRepository.findById(uniqueId);
        if (customer.isPresent()) {
            return "E-card issued successfully for: " + uniqueId;
        }
        return "Customer not found";
    }

    public String approveCustomer(String uniqueId) {
        Optional<SbicCustomer> customer = sbicCustomerRepository.findById(uniqueId);
        if (customer.isPresent()) {
            return "Customer approved: " + uniqueId;
        }
        return "Customer not found";
    }

    public String showECard(String uniqueId) {
        Optional<SbicCustomer> customer = sbicCustomerRepository.findById(uniqueId);
        if (customer.isPresent()) {
            return "Displaying E-card for: " + uniqueId;
        }
        return "Customer not found";
    }
}
