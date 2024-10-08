package com.evidences.user.controller;

import com.evidences.user.dto.UserLogin;
import com.evidences.user.entity.User;
import com.evidences.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api")
public class LoginController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody @Validated UserLogin userLogin) {
        User user = userService.userLogin(userLogin);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.ok(user);
        }
    }
}
