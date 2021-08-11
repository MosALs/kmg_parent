package com.home.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Repository.ProductRepository;
import com.home.entities.ProductEntity;
@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	ProductRepository  productRepository; 
//	@Override
//	public int save(ProductEntity productEntity) {
//		return 
//	}

	@Override
	public int save(ProductEntity productEntity) {
		productRepository.save(productEntity);
		return 1;
	}

}
