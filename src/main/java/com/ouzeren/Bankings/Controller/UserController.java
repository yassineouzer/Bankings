package com.ouzeren.Bankings.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ouzeren.Bankings.Dto.UserDto;
import com.ouzeren.Bankings.Service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private   final UserService service;
	
	
	
	@PostMapping("/")
	public ResponseEntity<Integer> Save(@RequestBody() UserDto userdto) {

		return new ResponseEntity<>(service.save(userdto), HttpStatus.CREATED);
	}
	
	
	
	public ResponseEntity<List<UserDto>> findAll() {
		
		
		return  ResponseEntity.ok(service.findAll());
		
		
	}
	
	@GetMapping("/user-id")
	public ResponseEntity<UserDto> findById(@PathVariable("user-id")Integer userId){
		
		
		return ResponseEntity.ok(service.findById(userId));
	}
	
	
	@DeleteMapping("/user-id")
	public ResponseEntity<Void> delete(@PathVariable("user-id")Integer userid){
		
		service.delete(userid);
		
		
		return  ResponseEntity.noContent().build();
	}
	
	

}
