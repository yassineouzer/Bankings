package com.ouzeren.Bankings.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouzeren.Bankings.Entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
