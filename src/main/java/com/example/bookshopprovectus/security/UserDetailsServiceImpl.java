package com.example.bookshopprovectus.security;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookshopprovectus.models.Role;
import com.example.bookshopprovectus.models.User;
import com.example.bookshopprovectus.repositories.UserRepository;

/**
 * 
 * @author Vitaly
 *
 */

@Service
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = usersRepository.findByLogin(login)
				.orElseThrow(() -> new UsernameNotFoundException("Email " + login + " not found"));
		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
				getAuthorities(user));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
		String[] userRoles = user.getRoles().stream().map(Role::getRole).map(s -> "ROLE_" + s).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}
}