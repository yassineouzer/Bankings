package com.ouzeren.Bankings.Service.Implements;

import java.util.List;
import java.util.stream.Collectors;

import com.ouzeren.Bankings.Dto.ContactDto;
import com.ouzeren.Bankings.Entities.Contact;
import com.ouzeren.Bankings.Repos.ContactRepository;
import com.ouzeren.Bankings.Service.ContactService;

public class ContactServiceImpl implements ContactService{

	
	private ContactRepository contactrepo;
	
	@Override
	public Integer save(ContactDto dto) {
		Contact contact =ContactDto.toEntity(dto);
		return contactrepo.save(contact).getId();
	}

	@Override
	public List<ContactDto> findAll() {
		
		return contactrepo.findAll().stream().map(w->ContactDto.fromEntity(w)).collect(Collectors.toList());
	}

	@Override
	public ContactDto findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		
		contactrepo.deleteById(id);
		
	}

}
