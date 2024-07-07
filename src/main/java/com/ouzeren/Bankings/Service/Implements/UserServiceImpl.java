package com.ouzeren.Bankings.Service.Implements;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ouzeren.Bankings.Dto.UserDto;
import com.ouzeren.Bankings.Entities.User;
import com.ouzeren.Bankings.Repos.UserRepository;
import com.ouzeren.Bankings.Service.UserService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	
	private final UserRepository   repository;

	
	
	@PostMapping("/")
	public Integer save(UserDto dto) {
		
		
		 User user = UserDto.toEntity(dto);
		 
		return repository.save(user).getId();
		 
	}

    @GetMapping("")
	public List<UserDto> findAll() {
        
		                                     // methode de reference
		return repository.findAll().stream().map(UserDto::fromEntity).collect(Collectors.toList());
	}

	@GetMapping("")
	public UserDto findById(Integer id) {
	     return null;
		/* return repository.findById(id).stream().map(w->UserDto.fromEntity(w))); */
	}

	@Override
	public void delete(Integer id) {
	
		 repository.deleteById(id);
		
	}

}
