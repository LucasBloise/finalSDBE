package com.lucasb.finalsd.controllers;

import com.lucasb.finalsd.entities.User;
import com.lucasb.finalsd.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@AuthenticationPrincipal Jwt jwt) {
        System.out.println(jwt);
        String externalId = jwt.getSubject();
        User newUser = userService.createUser(externalId);
        return ResponseEntity.ok(newUser);
    }
} 