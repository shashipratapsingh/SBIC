package com.SBICARD.service;

import com.SBICARD.model.request.UsersRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    int createUser(UsersRequest usersRequest);
}