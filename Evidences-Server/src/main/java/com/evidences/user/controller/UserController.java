package com.evidences.user.controller;

import com.evidences.user.dto.UserStatistics;
import com.evidences.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@Validated
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/statistics")
    public ResponseEntity<?> getUserStatistics(@NotBlank String userId) {
        UserStatistics userStatistics = userService.getUserStatistics(userId);

        if (userStatistics == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userStatistics);
        }
    }
}
