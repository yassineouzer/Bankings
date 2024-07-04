package com.ouzeren.Bankings.Dto;

import com.ouzeren.Bankings.Entities.Account;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountDto {

	
	private String iban;
	
	private UserDto user;
	
	
	public static AccountDto fromEntity(Account account) {
		return AccountDto.builder()
			.iban(account.getIban())
			.user(UserDto.fromEntity(account.getUser()))
				.build();
	}
	
	
	
	public static Account toEntity(AccountDto accountdto) {
		return Account.builder()
		.iban(accountdto.getIban())
		.user(UserDto.toEntity(accountdto.getUser()))
				
		.build();}
	
}
