package com.codebase.edic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codebase.edic.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // New method to find user by email
}