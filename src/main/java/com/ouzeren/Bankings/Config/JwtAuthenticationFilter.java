package com.ouzeren.Bankings.Config;

import java.io.IOException;


import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ouzeren.Bankings.Repos.UserRepository;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	
	private UserRepository userrepo;
	
	private Jwts  jwtUtils;
	
	private static final String AUTHORIZATION = "authorization";

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			
			HttpServletResponse response, 
			
			FilterChain filterChain)
	
	
	
			throws ServletException, IOException {
		
		
		String authHeader =request.getHeader(AUTHORIZATION);
	}

}
