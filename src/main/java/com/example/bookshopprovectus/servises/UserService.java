package com.example.bookshopprovectus.servises;

import java.util.Optional;

import com.example.bookshopprovectus.models.User;

public interface UserService {
	void save(User user);

	Optional<User> findByLogin(String login);
}