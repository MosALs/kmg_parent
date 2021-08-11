package com.home.Service;

import org.springframework.stereotype.Service;

import com.home.entities.ProductEntity;

@Service
public interface ProductService {

	int save(ProductEntity productEntity);
	
}
