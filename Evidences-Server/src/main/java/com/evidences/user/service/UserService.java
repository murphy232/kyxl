package com.evidences.user.service;

import com.evidences.user.entity.User;
import com.evidences.user.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User userLogin(String userId) {
        return userMapper.getUserInfo(userId);
    }
}
