package com.ouzeren.Bankings.Dto;


import com.ouzeren.Bankings.Entities.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoleDto {

	
	private String nom;
	
	
	private UserDto user;
	
	
	public static RoleDto fromEntity(Role role) {
		return RoleDto.builder()
			.nom(role.getNom())
			.user(UserDto.fromEntity(role.getUser()))
				.build();
	}
	
	
	
	public static Role toEntity(RoleDto roledto) {
		return Role.builder()
		.nom(roledto.getNom())
		.user(UserDto.toEntity(roledto.getUser()))
				
		.build();}
	
	
	
	
	
	
	
	
	
}
