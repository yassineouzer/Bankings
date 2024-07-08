package com.ouzeren.Bankings.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ouzeren.Bankings.Dto.TransactionDto;
import com.ouzeren.Bankings.Service.TransactionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping
@CrossOrigin
public class TransactionController {

	
	
	private final TransactionService transactionser;
	
	
	
	
	public ResponseEntity<Integer> save(TransactionDto transaction){
		
		return ResponseEntity.ok(transactionser.save(transaction));
	}
	
	
	public ResponseEntity<List<TransactionDto>> findAll(){
		
		
		return ResponseEntity.ok(transactionser.findAll());
	}
	
	
	
	public ResponseEntity<Void> delete(@PathVariable("transaction-id")Integer transactionid){
		
		transactionser.delete(transactionid);
		
		return null;
		
		
		
		
	}
}
