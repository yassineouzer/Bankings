package com.ouzeren.Bankings.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="contacts")
public class Contact extends AbstractEntity{

	@Getter @Setter
	private String firstname;
	 
	@Getter @Setter
	private String lastname;
	
	
	@Getter @Setter
	private String  email;
	
	@Getter @Setter
	private String iban;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

}
