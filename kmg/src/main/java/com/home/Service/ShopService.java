package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.DTO.UserProfileFullInfoDTO;
import com.home.entities.ShopEntity;
import com.home.util.ReturnedResultModel;

import javassist.NotFoundException;

@Service
public interface ShopService {

	int save(ShopEntity shopEntity);

	List<ShopEntity> getAllShop();

	ShopEntity getByShopID(int id);

	int getByshopName(String shopName);

	void deleteByshopID(int id);

	int ModifyByshop(String newshopName, String oldshopNamee);

	ReturnedResultModel getByUserId(int userId)throws NotFoundException;
	ReturnedResultModel getByUserIdShop(int userId)throws NotFoundException;

}
