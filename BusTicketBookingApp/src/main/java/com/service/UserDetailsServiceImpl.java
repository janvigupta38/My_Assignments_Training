package com.service;


import java.util.Arrays;
import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Login;
import com.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> userDetails= userRepository.findByUsername(username);
		List<GrantedAuthority> list=Arrays.stream(userDetails.get().getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		if(!userDetails.isEmpty()) {
			return new UserDetailsImpl(username,userDetails.get().getPassword(),list);
		}
		throw new UsernameNotFoundException("User Not Found with username: " + username);
	}

}
