package com.ouzeren.Bankings.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouzeren.Bankings.Entities.Transaction;


public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{

}
