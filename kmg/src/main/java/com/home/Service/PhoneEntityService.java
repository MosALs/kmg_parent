package com.home.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.home.entities.PhoneEntity;


@Service
public interface PhoneEntityService {

	  int save(PhoneEntity phoneEntity);
	  
	 PhoneEntity getPhoneById(int id);

	List<PhoneEntity> geAllPhoneIn(Set<Integer> phoneIds);
}
