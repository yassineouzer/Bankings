package com.ouzeren.Bankings.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="roles")
@Builder
@AllArgsConstructor
public class Role extends AbstractEntity{

	
	
	
	
    @Getter @Setter
	private String nom;

    
    
    @Getter @Setter
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;





	
	
}
