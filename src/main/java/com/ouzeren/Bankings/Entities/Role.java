package com.ouzeren.Bankings.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="roles")
public class Role extends AbstractEntity{

    @Getter @Setter
	private String nom;

	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	
}
