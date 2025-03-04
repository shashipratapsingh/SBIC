package com.SBICARD.service.impl;

import com.SBICARD.entity.Users;
import com.SBICARD.mapper.UserMapper;
import com.SBICARD.model.request.UsersRequest;
import com.SBICARD.repository.UsersRepository;
import com.SBICARD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository repository;

    @Override
    public int createUser(UsersRequest usersRequest) {
        Users users = UserMapper.toUser(usersRequest);
        users = repository.save(users);
        return users.getId();
    }
}
