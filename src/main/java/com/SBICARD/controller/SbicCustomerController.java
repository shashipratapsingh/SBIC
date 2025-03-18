package com.SBICARD.controller;

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
    public ResponseEntity<SbicCustomer> createCustomerProfile(@RequestBody SbicCustomer sbicCustomer) {
        return ResponseEntity.ok(sbicCustomerService.createOrUpdateProfile(sbicCustomer));
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

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @PostMapping("/approve/{uniqueId}")
    public ResponseEntity<String> approveCustomer(@PathVariable String uniqueId) {
        return ResponseEntity.ok(sbicCustomerService.approveCustomer(uniqueId));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @GetMapping("/show-ecard/{uniqueId}")
    public ResponseEntity<String> showECard(@PathVariable String uniqueId) {
        return ResponseEntity.ok(sbicCustomerService.showECard(uniqueId));
    }
}
