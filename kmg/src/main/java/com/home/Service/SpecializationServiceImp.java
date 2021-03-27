package com.home.Service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Entity.Specialization;
import com.home.Repository.SpecializationRepository;
import com.home.entities.SpecializationEntity;

@Service
public class SpecializationServiceImp implements SpecializationService {

	@Autowired
	private SpecializationRepository specializationRepository;

	@Override
	public int save(SpecializationEntity specializationEntity) {
		specializationRepository.save(specializationEntity);
		return 0;
	}

	@Override
	public List<SpecializationEntity> getAllspecialization() {
		specializationRepository.findAll();
		return null;
	}

	@Override
	public SpecializationEntity getBySpecializationID(int id) {
		return specializationRepository.findById(id);
		
	}

	@Override
	public int getBySpecializationName(String specializationName) {
		specializationRepository.findBySpecializationName(specializationName);
		return 0;
	}

	@Override
	public int deleteBySpecializationID(int id) {
		specializationRepository.deleteById(id);
		return 0;
	}

	@Override
	public int ModifyBySpecializationName(String newspecializationName, String oldspecializationName) {
	 specializationRepository.updateSpecialization(newspecializationName, oldspecializationName);
		return 0;
	}

	@Override
	public List<SpecializationEntity> getAllspecializationIn(Set<Integer> specIds) {
		
		return specializationRepository.findAllIn(specIds);
	}


	

}
