package com.ouzeren.Bankings.Service.Implements;

import java.util.List;
import java.util.stream.Collectors;

import com.ouzeren.Bankings.Dto.AdressDto;
import com.ouzeren.Bankings.Entities.Adress;
import com.ouzeren.Bankings.Repos.AdressRepository;
import com.ouzeren.Bankings.Service.AdressService;

public class AdressServiceImpl  implements AdressService {

      private AdressRepository adressrepo;
	
	
	
	public Integer save(AdressDto dto) {
		
		Adress adress = AdressDto.toEntity(dto);
		
		return adressrepo.save(adress).getId();
	}

	@Override
	public List<AdressDto> findAll() {
		
		
		return adressrepo.findAll().stream().map(y->AdressDto.fromEntity(y)).collect(Collectors.toList());
	}

	@Override
	public AdressDto findById(Integer id) {
		
		return adressrepo.findById(id).stream().map(e->AdressDto.fromEntity(e)).collect(null);
	}

	@Override
	public void delete(Integer id) {
		adressrepo.deleteById(id);
		
	}

}
