package com.ouzeren.Bankings.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ouzeren.Bankings.Dto.AccountDto;
import com.ouzeren.Bankings.Service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AccountController {

	
	
	
	private final AccountService account;
	
	
	
	
	public ResponseEntity<Integer> save(AccountDto accountdto){
		
		
		return new ResponseEntity<>(account.save(accountdto),HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<List<AccountDto>> findAll(){
		
		
		
		return ResponseEntity.ok(account.findAll());}
	
	
	public ResponseEntity<Void> delete(@PathVariable("account-id")Integer accountid){
		
		
		account.delete(accountid);
		
		
		return null;
	}
		
		
		
		
	
	
	
}
