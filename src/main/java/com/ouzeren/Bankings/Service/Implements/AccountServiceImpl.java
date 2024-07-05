package com.ouzeren.Bankings.Service.Implements;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ouzeren.Bankings.Dto.AccountDto;
import com.ouzeren.Bankings.Entities.Account;
import com.ouzeren.Bankings.Repos.AccountRepository;
import com.ouzeren.Bankings.Service.AccountService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

	
	private AccountRepository accountrepository;
	
	@Override
	public Integer save(AccountDto dto) {
		Account account = AccountDto.toEntity(dto);
		
		
		return  accountrepository.save(account).getId();
	}

	@Override
	public List<AccountDto> findAll() {
		                                            // la variable u peut etre n'importe quelle autre lettre juste pour parcouri
		return accountrepository.findAll().stream().map(u->AccountDto.fromEntity(u)).collect(Collectors.toList());
	
	}

	@Override
	public AccountDto findById(Integer id) {
	
		return (AccountDto) accountrepository.findById(id).stream().map(r->AccountDto.fromEntity(r)).collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		
		accountrepository.deleteById(id);
		
	}

}
