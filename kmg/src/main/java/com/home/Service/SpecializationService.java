package com.home.Service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.home.entities.SpecializationEntity;

@Service
public interface SpecializationService {

	int save(SpecializationEntity specializationEntity);

	 List<SpecializationEntity> getAllspecialization();
	 
	SpecializationEntity getBySpecializationID(int id);
	
	int getBySpecializationName(String specializationName);

	int deleteBySpecializationID(int id);

	int ModifyBySpecializationName(String newspecializationName, String oldspecializationName);

	List<SpecializationEntity> getAllspecializationIn(Set<Integer> specIds);


}
