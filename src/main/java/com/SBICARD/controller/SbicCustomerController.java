package com.SBICARD.controller;

import com.SBICARD.dto.SbicCustomerRequest;
import com.SBICARD.dto.SbicCustomerResponse;
import com.SBICARD.entity.SbicCustomer;
import com.SBICARD.service.SbicCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sbic/customers")
public class SbicCustomerController {

    private final SbicCustomerService sbicCustomerService;

    public SbicCustomerController(SbicCustomerService sbicCustomerService) {
        this.sbicCustomerService = sbicCustomerService;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @PostMapping("/create")
    public ResponseEntity<SbicCustomerResponse> createCustomerProfile(@RequestBody SbicCustomerRequest sbicCustomerRequest) {
        return ResponseEntity.ok(sbicCustomerService.createOrUpdateProfile(sbicCustomerRequest));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @PostMapping("/kyc/{uniqueId}")
    public ResponseEntity<String> kycCustomer(@PathVariable String uniqueId, @RequestParam int cibilScore,
                                              @RequestParam String adharCardNo, @RequestParam String uniqueAccountIdentifier,
                                              @RequestParam double income) {
        return ResponseEntity.ok(sbicCustomerService.kycCustomer(uniqueId, cibilScore, adharCardNo, uniqueAccountIdentifier, income));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @PostMapping("/approve/{uniqueId}")
    public ResponseEntity<String> approveCustomer(@PathVariable String uniqueId) {
        return ResponseEntity.ok(sbicCustomerService.approveCustomer(uniqueId));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @GetMapping("/{uniqueId}")
    public ResponseEntity<SbicCustomer> getCustomerProfile(@PathVariable String uniqueId) {
        return ResponseEntity.ok(sbicCustomerService.getCustomerProfile(uniqueId));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @PostMapping("/issue-ecard/{uniqueId}")
    public ResponseEntity<String> issueECard(@PathVariable String uniqueId) {
        return ResponseEntity.ok(sbicCustomerService.issueECard(uniqueId));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager','ROLE_User')")
    @GetMapping("/show-ecard/{uniqueId}")
    public ResponseEntity<String> showECard(@PathVariable String uniqueId) {
        return ResponseEntity.ok(sbicCustomerService.showECard(uniqueId));
    }
}
