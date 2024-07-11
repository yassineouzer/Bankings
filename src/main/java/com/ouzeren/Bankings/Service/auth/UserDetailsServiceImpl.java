package com.ouzeren.Bankings.Service.auth;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ouzeren.Bankings.Repos.UserRepository;

import lombok.RequiredArgsConstructor;




@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	
	private final UserRepository  repo;
	
	
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		
		
		return repo.findByEmail(email);
	}

}
