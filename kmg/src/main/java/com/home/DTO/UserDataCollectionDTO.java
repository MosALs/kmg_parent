package com.home.DTO;

import com.home.entities.PhoneEntity;

public class UserDataCollectionDTO {
	
	private PhoneEntity phone;
	private String locationName;

	private String areaName;
	private String governoratName;
	private String countryName;
	private String specializationName;
	
	public UserDataCollectionDTO() {
		super();
	}
	
	
	
	public UserDataCollectionDTO(PhoneEntity phone, String locationName , String areaName,
			String governoratName, String countryName ,String specializationName) {
		super();
		this.phone = phone;
		this.locationName = locationName;
		
		this.areaName = areaName;
		this.governoratName = governoratName;
		this.countryName = countryName;
		this.specializationName = specializationName;
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
