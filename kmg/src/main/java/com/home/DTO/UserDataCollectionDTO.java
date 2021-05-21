package com.home.DTO;

import com.home.entities.PhoneEntity;

public class UserDataCollectionDTO {
	
	private PhoneEntity phone;
	private String locationName;
	private String specializationName;
	
	
	
	
	public UserDataCollectionDTO() {
		super();
	}
	public UserDataCollectionDTO(PhoneEntity phone, String locationName, String specializationName) {
		super();
		this.phone = phone;
		this.locationName = locationName;
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
	
	
	
	
	
	
}
