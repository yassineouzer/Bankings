package com.ouzeren.Bankings.Entities;



import java.time.LocalDateTime;

import java.util.List;



import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "users")
public class User  extends AbstractEntity{

	
    @Getter   @Setter
	private String firstname;
    
    @Getter @Setter
	private String email;

    
    @Getter   @Setter
	private String password;
	
	
	private boolean active;

	   @Getter   @Setter
	private LocalDateTime birthdate; 

	@OneToMany(mappedBy = "user") 
	private List<Transaction> transactions;
	
	@OneToMany(mappedBy = "user")
	private List<Contact> contacts;

	@OneToOne
	private Account account;

	@OneToOne
	private Adress adresse;

	@OneToOne
	private Role role;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}