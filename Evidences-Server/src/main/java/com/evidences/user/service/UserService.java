package com.evidences.user.service;

import com.evidences.user.dto.UserLogin;
import com.evidences.user.dto.UserStatistics;
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

    public User userLogin(UserLogin userLogin) {
        return userMapper.userAuthorization(userLogin);
    }

    public UserStatistics getUserStatistics(String userId) {
        return userMapper.getUserStatistics(userId);
    }
}
