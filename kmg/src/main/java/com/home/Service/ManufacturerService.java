package com.home.Service;

import org.springframework.stereotype.Service;

import com.home.entities.ManufacturerEntity;

@Service
public interface ManufacturerService {
	int save(ManufacturerEntity manufacturerEntity);

}
