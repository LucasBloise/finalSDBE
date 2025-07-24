package com.lucasb.finalsd.services.impl;

import com.lucasb.finalsd.entities.User;
import com.lucasb.finalsd.repositories.UserRepository;
import com.lucasb.finalsd.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
} 