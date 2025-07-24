package com.lucasb.finalsd.services;

import com.lucasb.finalsd.entities.User;

public interface UserService {
    User createUser(String externalId);
} 