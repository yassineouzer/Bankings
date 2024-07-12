package com.ouzeren.Bankings.Config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, 
			
			FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String jwt =request.getHeader("Authorization");
		
		if(jwt ==null || !jwt.startsWith("Bearer ")) {
			
			filterChain.doFilter(request, response);
			return;
		}
		
           JWTVerifier verifier =JWT.require(Algorithm.HMAC256("ouzereny@gmail.com")).build();
		    
           
           jwt=jwt.substring(7);
           
           DecodedJWT decodedJWT =verifier.verify(jwt);
           
           
         String username=  decodedJWT.getSubject();
         
        List<String> roles= decodedJWT.getClaims().get("roles").asList(String.class);
        
        Collection<GrantedAuthority> authorities =new ArrayList<>();
        
        roles.forEach(u->{
        	authorities.add(new SimpleGrantedAuthority(u));
        });
        
        UsernamePasswordAuthenticationToken user = UsernamePasswordAuthenticationToken(user,null,authorities);
        	
		
	}

	private UsernamePasswordAuthenticationToken UsernamePasswordAuthenticationToken(
			UsernamePasswordAuthenticationToken user, Object object, Collection<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		return null;
	}

}
