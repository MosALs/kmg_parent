package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.DTO.UserProfileFullInfoDTO;
import com.home.Repository.ShopRepository;
import com.home.Service.ShopService;
import com.home.entities.ShopEntity;

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

//	// @PostMapping(value = "/{id}")
//	@GetMapping(value = "{id}")
//	List<ShopEntity> getShopById(@PathVariable(value = "id") int userId) {
//		// findByUserId() from table shop 
//		// findById() from table user
//		
//		return shopService.getByUserId(userId);
//	}/
	@GetMapping(value = "/info")
	public ResponseEntity<?> getShopById1(@RequestBody UserProfileFullInfoDTO infoDTO) {
		// findByUserId() from table shop 
		// findById() from table user
		//UserProfileFullInfoDTO profileFullInfoDTO=new UserProfileFullInfoDTO();
		//profileFullInfoDTO.getLocationName();
		//infoDTO.getAccountTypeName();
		infoDTO.setAccountTypeName(infoDTO.getAccountTypeName());
		return ResponseEntity.ok(infoDTO);
	}

}
