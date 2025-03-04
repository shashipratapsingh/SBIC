package com.SBICARD.controller;

import com.SBICARD.dto.StudentRequestDTO;
import com.SBICARD.dto.StudentResponseDTO;
import com.SBICARD.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @PostMapping("/")
    public ResponseEntity<StudentResponseDTO> createCustomer(@RequestBody StudentRequestDTO studentRequest) {
        return ResponseEntity.ok(studentService.save(studentRequest));
    }
}
