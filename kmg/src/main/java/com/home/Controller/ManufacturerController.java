package com.home.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.Service.ManufacturerService;
import com.home.entities.ManufacturerEntity;

@RestController
public class ManufacturerController {

	@Autowired
	ManufacturerService manufacturerService;

	@RequestMapping(value = "/addmanfa", method = RequestMethod.POST)
	public int add(@RequestBody ManufacturerEntity manufacturerEntity) {

		return manufacturerService.save(manufacturerEntity);
	}
	

}