package com.ouzeren.Bankings.Entities;



import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "users")
@Builder
public  class User  extends AbstractEntity implements UserDetails{

	
	
	 @Getter   @Setter
	private Integer id;
	
	
    @Getter   @Setter
	private String firstname;
    
    @Getter   @Setter
    private String lastname;
    
    
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
	 @Getter   @Setter
	private Account account;

	@OneToOne
	 @Getter   @Setter
	private Adress adresse;

	@OneToOne
	 @Getter   @Setter
	private Role role;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

public boolean isAccountNonExpired() {
	
	return true;
}


public boolean isAccountNonLocked() {
	
	return false;
}


public boolean isEnabled() {
	
	return true;
}

}