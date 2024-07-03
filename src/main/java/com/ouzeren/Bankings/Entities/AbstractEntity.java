package com.ouzeren.Bankings.Entities;


import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AbstractEntity {
	
	
	
	@Id
	@GeneratedValue
	private Integer id;

	@CreatedDate
	@Column(name="createdDate",
	nullable = false,
	updatable = false)
	private LocalDateTime createdDate;
     
	
	@LastModifiedDate
	@Column(name="LastModifiedDate")
	private LocalDateTime LastModifiedDate;
}
