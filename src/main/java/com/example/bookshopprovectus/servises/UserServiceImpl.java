package com.example.bookshopprovectus.servises;

import java.util.Collections;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bookshopprovectus.models.User;
import com.example.bookshopprovectus.repositories.RoleRepository;
import com.example.bookshopprovectus.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findAllById(Collections.singleton(1L)));
		userRepository.save(user);
	}

	@Override
	public Optional<User> findByLogin(String login) {
		return userRepository.findByLogin(login);
	}
}