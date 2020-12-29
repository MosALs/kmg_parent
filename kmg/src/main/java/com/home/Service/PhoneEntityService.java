package com.home.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.home.entities.PhoneEntity;


@Service
public interface PhoneEntityService {

	  int save(PhoneEntity phoneEntity);
	  
	 PhoneEntity getPhoneById(int id);
}
