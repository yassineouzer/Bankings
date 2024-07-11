package com.ouzeren.Bankings.Service.auth;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ouzeren.Bankings.Entities.User;
import com.ouzeren.Bankings.Repos.UserRepository;

import lombok.RequiredArgsConstructor;




@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	
	private final UserRepository  repo;
	
	
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = (User) repo.findByEmail(email);
		
		
		
		if(user==null) 
			throw new  UsernameNotFoundException("utilisateur introuvable");
 		
		
		

		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthorities());
	}

}