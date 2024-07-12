package com.ouzeren.Bankings.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	
	
	private   final UserDetailsService  userDetailsService;
	private  AuthenticationManager authMng;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
        
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                
                .authorizeHttpRequests((re) -> re.requestMatchers("/auth", "/register").permitAll()
                		
                .anyRequest().authenticated())
                
               .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore( new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
             
	      
	     
		
	
		
		
		return http.build();
		
		
		
	};
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		
		
		
		return config.getAuthenticationManager();
		
		
		
		
	};
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authenticationprovider = new DaoAuthenticationProvider();
		
		authenticationprovider.setUserDetailsService(userDetailsService);
		authenticationprovider.setPasswordEncoder(PasswordEncoder());
		
		return authenticationprovider;
		
		
		
	}

     @Bean
	private PasswordEncoder PasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
