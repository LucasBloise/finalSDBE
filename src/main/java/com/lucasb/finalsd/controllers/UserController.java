package com.lucasb.finalsd.controllers;

import com.lucasb.finalsd.entities.User;
import com.lucasb.finalsd.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lucasb.finalsd.entities.Favorite;
import com.lucasb.finalsd.model.dto.FavoriteRequestDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Set;

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

    @PostMapping("/favorites")
    public ResponseEntity<Favorite> addFavorite(@AuthenticationPrincipal Jwt jwt, @RequestBody FavoriteRequestDTO favoriteRequest) {
        String externalId = jwt.getSubject();
        Favorite newFavorite = userService.addFavorite(externalId, favoriteRequest.getCharacterId());
        return ResponseEntity.ok(newFavorite);
    }

    @GetMapping("/favorites")
    public ResponseEntity<Set<Favorite>> getFavorites(@AuthenticationPrincipal Jwt jwt) {
        String externalId = jwt.getSubject();
        Set<Favorite> favorites = userService.getFavorites(externalId);
        return ResponseEntity.ok(favorites);
    }
} 