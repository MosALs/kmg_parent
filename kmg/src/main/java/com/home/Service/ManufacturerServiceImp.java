package com.home.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Repository.ManufacturerRepository;
import com.home.entities.ManufacturerEntity;

@Service
public class ManufacturerServiceImp implements ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;

	@Override
	public int save(ManufacturerEntity manufacturerEntity) {
		manufacturerRepository.save(manufacturerEntity);
		return 1;
	}

}
