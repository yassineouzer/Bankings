package com.ouzeren.Bankings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class BankingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingsApplication.class, args);
	}

}
