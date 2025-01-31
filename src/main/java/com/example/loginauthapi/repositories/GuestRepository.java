package com.example.loginauthapi.repositories;

import com.example.loginauthapi.model.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GuestRepository extends MongoRepository<Guest, String> {
    Optional<Guest> findByDayOfWeek(String dayOfWeek);
}