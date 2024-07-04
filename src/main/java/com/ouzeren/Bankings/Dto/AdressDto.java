package com.ouzeren.Bankings.Dto;


import com.ouzeren.Bankings.Entities.Adress;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class AdressDto {

	
	
	private String street;
	
	
	
	private Integer houseNumber;
	
	private Integer zipCode;
	
	private String city;
	
	
	private String country;
	
	private UserDto user;
	
	public static AdressDto fromEntity(Adress adress) {
		
		return  AdressDto.builder()
		.street(adress.getStreet())
		.houseNumber(adress.getHouseNumber())
		.zipCode(adress.getZipCode())
		.city(adress.getCity())
		.country(adress.getCountry())
		.user(UserDto.fromEntity(adress.getUser()))
		
				.build();
		}
	
	
	
	
	public static Adress toEntity(AdressDto adressdto) {
		return Adress.builder()
				.street(adressdto.getStreet())
				.houseNumber(adressdto.getHouseNumber())
				.zipCode(adressdto.getZipCode())
				.city(adressdto.getCity())
				.country(adressdto.getCountry())
		.user(UserDto.toEntity(adressdto.getUser()))
				
		.build();}
}
