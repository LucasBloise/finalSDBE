package com.lucasb.finalsd.services;

import com.lucasb.finalsd.entities.User;
import com.lucasb.finalsd.entities.Favorite;
import java.util.Set;

public interface UserService {
    User createUser(String externalId);
    Favorite addFavorite(String externalId, Integer characterId);
    Set<Favorite> getFavorites(String externalId);
} 