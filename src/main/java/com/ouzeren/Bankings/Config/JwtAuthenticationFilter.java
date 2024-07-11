package com.ouzeren.Bankings.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	
	
	private AuthenticationManager authMng;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		
		User user =null;
		try {
			user= new ObjectMapper().readValue(request.getInputStream(), User.class);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return authMng.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, 
			FilterChain chain,
			Authentication authResult) 
					throws IOException, ServletException {
		
		
		org.springframework.security.core.userdetails.User springUser = 
				
				(org.springframework.security.core.userdetails.User) authResult.getPrincipal();
		
	List<String> roles = new ArrayList<>();
		
              springUser.getAuthorities().forEach(u->{
	             roles.add(u.getAuthority());
			  
  
  });
         String jwt =JWT.create().
        		 withSubject(springUser.getUsername()).
        		 withArrayClaim("roles",roles.toArray(new String[roles.size()])).
        		 withExpiresAt(new Date(System.currentTimeMillis()+10*24*60*60*1000)).
        		 sign(Algorithm.HMAC256("ouzereny@gmail.com"));
        	
			response.addHeader("Authorization", jwt);	

		
		
	};
	
	











}
