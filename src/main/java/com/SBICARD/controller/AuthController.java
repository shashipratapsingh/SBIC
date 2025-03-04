package com.SBICARD.controller;

import com.SBICARD.model.request.UsersRequest;
import com.SBICARD.model.response.UsersResponse;
import com.SBICARD.security.JWT.JwtRequest;
import com.SBICARD.security.JWT.JwtResponse;
import com.SBICARD.security.service.AuthService;
import com.SBICARD.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/sign")
    public ResponseEntity<UsersResponse> createUsers(@Valid @RequestBody UsersRequest usersRequest) {
        usersRequest.setPassword(passwordEncoder.encode(usersRequest.getPassword()));
        int userId = service.createUser(usersRequest);
        UsersResponse usersResponse = new UsersResponse();
        usersResponse.setUserId(userId);
        usersResponse.setMessage("User Created");
        return new ResponseEntity<>(usersResponse, HttpStatus.OK);
    }

        @PostMapping("/login")
    public ResponseEntity<JwtResponse> tokenGeneration(@RequestBody JwtRequest jwtRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            JwtResponse jwtResponse = new JwtResponse();
            jwtResponse.setEmail(jwtRequest.getEmail());
            jwtResponse.setToken(authService.GenerateToken(jwtRequest.getEmail()));
            return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
        } else {
            throw new UsernameNotFoundException("Invalid request");
        }
    }

    @PreAuthorize("hasAuthority('ROLE_Admin')")
    @GetMapping("/adminDashboard")
    public String adminDashboard() {
       return "Admin Dashboard";
    }
  //  @PreAuthorize("hasAuthority('ROLE_Manager','ROLE_Admin')")
  @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager')")
    @GetMapping("/managerDashboard")
    public String managerDashboard() {
        return "Manager Dashboard";
    }
    //@PreAuthorize("hasAuthority('ROLE_User','ROLE_Admin','ROLE_Manager')")
    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager','ROLE_User')")
    @GetMapping("/userDashboard")
    public String userDashboard() {
        return "User Dashboard";
    }
}