package com.ouzeren.Bankings.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="adresses")
public class Adress extends AbstractEntity{

	
	@Getter @Setter
	private String street;
	
	
	@Getter  @Setter
	private Integer houseNumber;
	
	
	@Getter  @Setter
	private Integer zipCode;
	
	
	@Getter @Setter
	private String city;
	
	
	@Getter  @Setter
	private String country;
	
	
	@OneToOne
	@JoinColumn(name="id_user")
	private User user;
}
