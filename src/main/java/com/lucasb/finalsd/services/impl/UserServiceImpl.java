package com.lucasb.finalsd.services.impl;

import com.lucasb.finalsd.entities.User;
import com.lucasb.finalsd.repositories.UserRepository;
import com.lucasb.finalsd.services.UserService;
import org.springframework.stereotype.Service;
import com.lucasb.finalsd.entities.Favorite;
import com.lucasb.finalsd.repositories.FavoriteRepository;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FavoriteRepository favoriteRepository;

    public UserServiceImpl(UserRepository userRepository, FavoriteRepository favoriteRepository) {
        this.userRepository = userRepository;
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public User createUser(String externalId) {
        if (userRepository.findByExternalId(externalId).isPresent()) {
            throw new IllegalStateException("User with external id " + externalId + " already exists");
        }
        User user = new User();
        user.setExternalId(externalId);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Favorite addFavorite(String externalId, Integer characterId) {
        User user = userRepository.findByExternalId(externalId)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setCharacterId(characterId);
        return favoriteRepository.save(favorite);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Favorite> getFavorites(String externalId) {
        User user = userRepository.findByExternalIdWithFavorites(externalId)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        return user.getFavorites();
    }
} 