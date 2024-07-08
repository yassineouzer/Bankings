package com.ouzeren.Bankings.Entities;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Entity
@Table(name="transactions")
public class Transaction extends AbstractEntity{

	
 
	 @Getter   @Setter
	private Integer id;
	
	
   @Getter   @Setter
   private BigDecimal amount;
   
   @Getter   @Setter
   private String destinationIban;
   
	
    @Enumerated(EnumType.STRING)
	private TransactionType  type;
	
    @Getter   @Setter
	private LocalDateTime dateCreation;
    
    @Getter   @Setter
	private LocalDateTime  lastUpdated;
    
    
    @Getter   @Setter
	  @ManyToOne
	  @JoinColumn(name="id_user") 
	  private User user;
	 
}
