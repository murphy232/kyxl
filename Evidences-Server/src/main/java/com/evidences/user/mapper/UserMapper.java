package com.evidences.user.mapper;

import com.evidences.user.dto.UserLogin;
import com.evidences.user.dto.UserStatistics;
import com.evidences.user.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User userAuthorization(UserLogin userLogin);

    UserStatistics getUserStatistics(String userId);
}
