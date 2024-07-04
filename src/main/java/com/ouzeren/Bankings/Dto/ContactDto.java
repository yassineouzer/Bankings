package com.ouzeren.Bankings.Dto;

import com.ouzeren.Bankings.Entities.Contact;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ContactDto {

	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String iban;
	
	private UserDto user;
	
	public static ContactDto  fromEntity(Contact contact) {
		
		
		return ContactDto.builder()
			.firstname(contact.getFirstname())
			.lastname(contact.getLastname())
			.email(contact.getEmail())
			.iban(contact.getIban())
			.user(UserDto.fromEntity(contact.getUser()))
				
				
				.build();
	}
	
	
	
	public static Contact toEntity(ContactDto  contactdto) {
		
		return  Contact.builder()
		.firstname(contactdto.getFirstname())
		.lastname(contactdto.getLastname())
		.email(contactdto.getEmail())
		.iban(contactdto.getIban())
		.user(UserDto.toEntity(contactdto.getUser()))
		
				
				
				.build();
	}
	
	
	
}
