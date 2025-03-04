package com.SBICARD.mapper;

import com.SBICARD.entity.Users;
import com.SBICARD.model.request.UsersRequest;
import org.springframework.beans.BeanUtils;

public class UserMapper {

    public  static Users toUser(UsersRequest usersRequest){
        Users users = new Users();
        BeanUtils.copyProperties(usersRequest, users);
        return users;
    }
}