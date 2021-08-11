package com.home.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.home.DTO.ShopProductDTO;
import com.home.Repository.ManufacturerRepository;
import com.home.Repository.ProductRepository;
import com.home.Repository.ProductTransactionRepository;
import com.home.Repository.ShopProductRepository;
import com.home.Repository.ShopRepository;
import com.home.entities.ManufacturerEntity;
import com.home.entities.ProductEntity;
import com.home.entities.ShopEntity;
import com.home.entities.ShopProductEntity;
import com.home.util.HelperResultUtil;
import com.home.util.ReturnedResultModel;

@Service
public class ShopProductServiceImp implements ShopProductService {
	@Autowired
	ProductTransactionRepository productTransactionRepository;
	@Autowired
	ShopProductRepository shopProductRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ManufacturerRepository manufacturerRepository;
	@Autowired
	ShopRepository  shopRepository;

	
	@Override
	public ReturnedResultModel ShopProductDTO(ShopProductDTO shopProductDTO) {

		 // ProductService
		// 1- save(Product) name - color - unitPrice - size
		
		// ManufucturerService 
		// 2- save(Manufacturer) name
		
		// ShopProductService
		// 3- save(ShopProduct) color - unitPrice - size - producId - manufacturerid - shopId
		
	
		ProductEntity productEntity=new ProductEntity();
//		productEntity.setProductname(productTransactionDTO.getProductname());
		productEntity.setProductName(shopProductDTO.getProductName());
		productEntity=productRepository.save(productEntity);
		
		ManufacturerEntity manufacturerEntity=new ManufacturerEntity();
		manufacturerEntity.setManufacturerName(shopProductDTO.getManufacturerName());
		manufacturerEntity=manufacturerRepository.save(manufacturerEntity);
		
		Optional<ShopEntity> shopEntity=shopRepository.findById(shopProductDTO.getShopId());
		
		ShopProductEntity shopProductEntity = new ShopProductEntity();
		shopProductEntity.setColor(shopProductDTO.getColor());
		shopProductEntity.setSize(shopProductDTO.getSize());
		shopProductEntity.setUnitPrice(shopProductDTO.getUnitPrice());
		shopProductEntity.setProductId(productEntity.getId());
		shopProductEntity.setManufacturerId(manufacturerEntity.getId());
		shopProductEntity.setShopByShopId(shopEntity.get());
		
		
		shopProductEntity=shopProductRepository.save(shopProductEntity);
		ReturnedResultModel r = HelperResultUtil.fillResultModel("shop product returned successfully", "no error",
				HttpStatus.OK, shopProductDTO);
		return r;
	}

}
