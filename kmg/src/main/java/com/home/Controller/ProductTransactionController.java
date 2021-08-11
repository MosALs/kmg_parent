package com.home.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.DTO.ShopProductDTO;
import com.home.Service.ShopProductService;
import com.home.util.ReturnedResultModel;

@RestController
class ProductTransactionController {

	@Autowired
	ShopProductService shopProductService;
	@PostMapping(value = "/AddPro")
	public ResponseEntity<?> add (@RequestBody ShopProductDTO shopProductDTO){
		ReturnedResultModel r = shopProductService.ShopProductDTO(shopProductDTO);
		return ResponseEntity.ok(r);
		
	}
	
}

