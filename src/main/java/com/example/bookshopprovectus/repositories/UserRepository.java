package com.example.bookshopprovectus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshopprovectus.models.User;

/**
 * 
 * @author Vitaly
 *
 */

public interface UserRepository extends JpaRepository<User, Short> {
	Optional<User> findByLogin(String login);
}