package com.ouzeren.Bankings.Dto;

import java.math.BigDecimal;

import com.ouzeren.Bankings.Entities.Transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
public class TransactionDto {

	
	   @Getter @Setter
	   private BigDecimal amount;
	   
	   
	   @Getter @Setter
	   private String destinationIban;
	   
	   
	   
	   @Getter @Setter
	   private UserDto user;
	   
	   
	   
	   public static TransactionDto fromEntity(Transaction transaction) {
		   
		   return TransactionDto.builder()
			.amount(transaction.getAmount())
			.destinationIban(transaction.getDestinationIban())
			.user(UserDto.fromEntity(transaction.getUser()))
				   
				   
				   
				   .build();
	   }
	   
	   
	   public static Transaction  toEntity(TransactionDto  transactiondto) {
		   
		   return Transaction.builder()
			.amount( transactiondto.getAmount())
			.destinationIban(transactiondto.getDestinationIban())
			.user(UserDto.toEntity(transactiondto.user))
				   
				   .build();
	   }
}
