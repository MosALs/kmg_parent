package com.home.Service;

import org.springframework.stereotype.Service;

import com.home.DTO.ShopProductDTO;
import com.home.entities.ShopProductEntity;
import com.home.util.ReturnedResultModel;

@Service
public interface ShopProductService {

	ReturnedResultModel ShopProductDTO(ShopProductDTO shopProductDTO);
	
}
