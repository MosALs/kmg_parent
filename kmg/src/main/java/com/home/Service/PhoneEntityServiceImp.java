package com.home.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Repository.PhoneRepository;
import com.home.entities.PhoneEntity;

@Service
public class PhoneEntityServiceImp implements PhoneEntityService{

	@Autowired
	private PhoneRepository phoneRepository; 
	
	@Override
	public int save(PhoneEntity phoneEntity) {
	     phoneRepository.save(phoneEntity);
		return 0;
	}

	@Override
	public PhoneEntity getPhoneById(int id) {
		Optional<PhoneEntity> optional=phoneRepository.findById(id);
		PhoneEntity phoneEntity=optional.get();
		return phoneEntity;
	}

	@Override
	public List<PhoneEntity> geAllPhoneIn(Set<Integer> phoneIds) {
	
		return phoneRepository.findAllIn(phoneIds);
	}
	
	

}
