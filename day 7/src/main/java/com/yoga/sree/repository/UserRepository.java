package com.yoga.sree.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoga.sree.model.User;

public interface UserRepository extends JpaRepository<User, String>{

    Optional<User> findByEmail(String email);
    
}
