package com.ouzeren.Bankings.Service.Implements;

import java.util.List;
import java.util.stream.Collectors;

import com.ouzeren.Bankings.Dto.TransactionDto;
import com.ouzeren.Bankings.Entities.Transaction;
import com.ouzeren.Bankings.Repos.TransactionRepository;
import com.ouzeren.Bankings.Service.TransactionService;

public class TransactionServiceImplements implements TransactionService {

	private TransactionRepository transactionrepo;

	@Override
	public Integer save(TransactionDto dto) {
		Transaction transaction = TransactionDto.toEntity(dto);
		return transactionrepo.save(transaction).getId();
	}

	@Override
	public List<TransactionDto> findAll() {

		return transactionrepo.findAll().stream().map(z -> TransactionDto.fromEntity(z)).collect(Collectors.toList());
	}

	/*
	 * @Override public TransactionDto findById(Integer id) {
	 * 
	 * 
	 * // return
	 * transactionrepo.findById(id).stream().map(TransactionDto::fromEntity).collect
	 * (Collectors.toList());
	 * 
	 * }
	 */
	@Override
	public void delete(Integer id) {
	
		transactionrepo.deleteById(id);

	}

	@Override
	public TransactionDto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
