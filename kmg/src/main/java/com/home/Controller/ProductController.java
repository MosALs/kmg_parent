package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.Repository.ShopProductRepository;
import com.home.Service.ProductService;
import com.home.entities.ProductEntity;
import com.home.entities.ShopProductEntity;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ShopProductRepository repo;

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public int add(@RequestBody ProductEntity productEntity) {

		return productService.save(productEntity);
	}

	@RequestMapping(value = "/getShopProducts", method = RequestMethod.GET)
	public List<ShopProductEntity> findAll() {

		return repo.findAll();
	}
}