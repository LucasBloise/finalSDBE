package com.lucasb.finalsd.repositories;

import com.lucasb.finalsd.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByExternalId(String externalId);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.favorites WHERE u.externalId = :externalId")
    Optional<User> findByExternalIdWithFavorites(@Param("externalId") String externalId);
} 