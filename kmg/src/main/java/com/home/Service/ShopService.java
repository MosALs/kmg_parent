package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.DTO.UserProfileFullInfoDTO;
import com.home.entities.ShopEntity;

@Service
public interface ShopService {

	int save(ShopEntity shopEntity);

	List<ShopEntity> getAllShop();

	ShopEntity getByShopID(int id);

	int getByshopName(String shopName);

	void deleteByshopID(int id);

	int ModifyByshop(String newshopName, String oldshopNamee);

	List<ShopEntity> getByUserId(int userId);

}
