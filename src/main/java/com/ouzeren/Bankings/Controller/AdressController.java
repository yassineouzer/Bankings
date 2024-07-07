package com.ouzeren.Bankings.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ouzeren.Bankings.Dto.AdressDto;
import com.ouzeren.Bankings.Service.AdressService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AdressController {

	
	
	private   AdressService adress;
	
	
	@PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody()AdressDto dto){
    	
    	return  new ResponseEntity<>(adress.save(dto),HttpStatus.CREATED);
    }
	
	@GetMapping("/adress-id")
	public ResponseEntity<List<AdressDto>> findAll(){
		
		
		return ResponseEntity.ok(adress.findAll());
	}
	
	@GetMapping("/")
	public ResponseEntity<AdressDto> findById(@PathVariable("user-id")Integer userId){
		
		return ResponseEntity.ok(adress.findById(userId));
	}
	
	
	public ResponseEntity<Void> delete(@PathVariable("adress-id")Integer adressid){
		
		adress.delete(adressid);
		
		return ResponseEntity.accepted().build();
	}
}
