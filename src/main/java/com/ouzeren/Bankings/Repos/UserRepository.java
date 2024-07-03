package com.ouzeren.Bankings.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ouzeren.Bankings.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	

	
	  List<User> findAllByFirstname(String firstname);
	  
	  
	  // en tenant en compte majuscule 
	  List<User> findAllByFirstnameContaining(String firstname);
	  
	  
	  // ca permet de rechercher les utulisateurs sans prendre en consideration  majuscule ou miniscule .
	  
	  List<User>findAllByFirstnameContainingIgnoreCase(String firstname);
	  
	  // rechercher user avec un iban specifique
	  
	  User findByAllAccountIban(String  iban);
	  
	  @Query("from User where firstname = :firstname") List<User>
	  searchFirstname(String firstname);
	  
	  
	  // en tenant en compte majuscule et en recherchant les utulisateurs qui  contient firstname commme par exemple les noms qui contient abd
	 
	  
	  @Query("from User where firstname ='%:firstname%'") 
	  List<User> searchFirstnameContaining(String firstname);
	  
	  @Query("from User u inner join  Account a on u.id = a.user.id where a.iban =:iban ") 
	     User serachAccountIban(String iban);
}

