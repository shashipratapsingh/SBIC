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
        sbicCustomer.setStatus("pending");
        return sbicCustomerRepository.save(sbicCustomer);
    }

    public String kycCustomer(String uniqueId, int cibilScore, String adharCardNo, String uniqueAccountIdentifier, double income) {
        Optional<SbicCustomer> customerOpt = sbicCustomerRepository.findById(uniqueId);
        if (customerOpt.isPresent()) {
            SbicCustomer customer = customerOpt.get();
            if (cibilScore >= 700 && income > 20000) {
                customer.setStatus("Done");
                sbicCustomerRepository.save(customer);
                return "KYC completed successfully for: " + uniqueId;
            } else {
                customer.setStatus("Rejected");
                sbicCustomerRepository.save(customer);
                return "KYC failed for: " + uniqueId;
            }
        }
        return "Customer not found";
    }

    public String approveCustomer(String uniqueId) {
        Optional<SbicCustomer> customerOpt = sbicCustomerRepository.findById(uniqueId);
        if (customerOpt.isPresent()) {
            SbicCustomer customer = customerOpt.get();
            if ("Done".equals(customer.getStatus())) {
                customer.setStatus("Approved");
                sbicCustomerRepository.save(customer);
                return "Customer approved: " + uniqueId;
            }
            return "KYC not completed, cannot approve customer: " + uniqueId;
        }
        return "Customer not found";
    }

    public String issueECard(String uniqueId) {
        Optional<SbicCustomer> customerOpt = sbicCustomerRepository.findById(uniqueId);
        if (customerOpt.isPresent()) {
            SbicCustomer customer = customerOpt.get();
            if ("Approved".equals(customer.getStatus())) {
                return "E-card issued successfully for: " + uniqueId;
            }
            return "Customer not approved, cannot issue E-card";
        }
        return "Customer not found";
    }

    public String showECard(String uniqueId) {
        Optional<SbicCustomer> customerOpt = sbicCustomerRepository.findById(uniqueId);
        if (customerOpt.isPresent()) {
            SbicCustomer customer = customerOpt.get();
            if ("Approved".equals(customer.getStatus())) {
                return "Displaying E-card for: " + uniqueId;
            }
            return "Customer not approved, E-card not available";
        }
        return "Customer not found";
    }

    public SbicCustomer getCustomerProfile(String uniqueId) {
        return sbicCustomerRepository.findById(uniqueId).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
