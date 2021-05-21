package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.Repository.ShopRepository;
import com.home.Service.ShopService;
import com.home.entities.ShopEntity;
import com.home.util.ReturnedResultModel;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "rest/sh")
public class ShopController {

	@Autowired
	ShopService shopService;
	@Autowired
	ShopRepository shopRepository;

	@GetMapping
	List<ShopEntity> getAll() {
		return shopService.getAllShop();
	}

	// @PostMapping(value = "/{id}")
	@GetMapping(value = "/user/{id}")
	ResponseEntity<ReturnedResultModel> getShopById(@PathVariable(value = "id") int userId) throws NotFoundException {
		ReturnedResultModel r = shopService.getByUserId(userId);
		return ResponseEntity.ok(r);
	}
	
//	
//	@GetMapping(value = "/info")
//	public ResponseEntity<?> getShopById1(@RequestBody UserProfileFullInfoDTO infoDTO) {
//		// findByUserId() from table shop 
//		// findById() from table user
//		//UserProfileFullInfoDTO profileFullInfoDTO=new UserProfileFullInfoDTO();
//		//profileFullInfoDTO.getLocationName();
//		//infoDTO.getAccountTypeName();
//		//infoDTO.setAccountTypeName(infoDTO.getAccountTypeName());
//		
//		return ResponseEntity.ok(infoDTO);
//	}

}
