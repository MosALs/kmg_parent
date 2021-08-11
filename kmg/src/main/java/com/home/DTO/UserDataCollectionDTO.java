package com.home.DTO;

import java.util.Collection;
import java.util.List;

import com.home.entities.PhoneEntity;
import com.home.entities.ShopEntity;
import com.home.entities.ShopProductEntity;

public class UserDataCollectionDTO {

	private PhoneEntity phone;
	private Collection<ShopProductEntity> shopProducts;
	private String locationName;
	private String areaName;
	private String governoratName;
	private String countryName;
	private String specializationName;

	public UserDataCollectionDTO() {
		super();
	}

	public UserDataCollectionDTO(PhoneEntity phone, String locationName, String areaName,
			String governoratName, String countryName, String specializationName, Collection<ShopProductEntity> shopProducts) {
		super();
		this.phone = phone;
		this.locationName = locationName;
		this.areaName = areaName;
		this.governoratName = governoratName;
		this.countryName = countryName;
		this.specializationName = specializationName;
		this.shopProducts = shopProducts;
	}

	public UserDataCollectionDTO(PhoneEntity phone, String locationName, String areaName, String governoratName,
			String countryName, String specializationName) {
		super();
		this.phone = phone;
		this.locationName = locationName;

		this.areaName = areaName;
		this.governoratName = governoratName;
		this.countryName = countryName;
		this.specializationName = specializationName;
	}


	public Collection<ShopProductEntity> getShopProducts() {
		return shopProducts;
	}

	public void setShopProducts(Collection<ShopProductEntity> shopProducts) {
		this.shopProducts = shopProducts;
	}

	public PhoneEntity getPhone() {
		return phone;
	}

	public void setPhone(PhoneEntity phone) {
		this.phone = phone;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getGovernoratName() {
		return governoratName;
	}

	public void setGovernoratName(String governoratName) {
		this.governoratName = governoratName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
