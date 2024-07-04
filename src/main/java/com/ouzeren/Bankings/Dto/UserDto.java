package com.ouzeren.Bankings.Dto;

import com.ouzeren.Bankings.Entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {

	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	
	private String password;
	
	
	
	public static UserDto fromEntity(User user) {
		return UserDto.builder()
				
		.firstname(user.getFirstname())	
		.lastname(user.getLastname())
		.email(user.getEmail())
		.password(user.getPassword()).build();
		}
	
	
	public static User toEntity(UserDto userd) {
		return User.builder()
				
		.firstname(userd.getFirstname())	
		.lastname(userd.getLastname())
		.email(userd.getEmail())
		.password(userd.getPassword()).build();}
	
}
