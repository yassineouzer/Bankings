package com.ouzeren.Bankings.Entities;

import jakarta.persistence.Entity;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="accounts")
@Builder
@Getter
@Setter
public class Account extends AbstractEntity{

	
	
	
	
	private Integer id;

	
	
	private String iban;
	

	
	
	@OneToOne
	@JoinColumn(name="id_user") 
	private User user;
	
}
