package com.home.DTO;

import java.sql.Date;
import java.util.List;

import com.home.entities.LocationEntity;
import com.home.entities.PhoneEntity;
import com.home.entities.SpecializationEntity;

public class UserProfileFullInfoDTO {

	private String name;
	private String userName;
	private String mobile;
	private byte[] userImage;
	private String websiteLink;
	private String facbookLink;
	private String password;
	private String locationName;
//	private String specializationName;
	private String accountTypeName;
	private String shopName;
	private String street;
	private Boolean active;
	private Date startDate;
	private String wholeRetailSale;
	private String deliveryNoDelivery;
//	private String mobileOne;
//	private String mobileTwo;
//	private String mobileThree;
//	private String mobileFour;
//	private String landLineOne;
//	private String landLineTwo;
//	private String landLineThree;
	private List<LocationEntity> Locations;
	private List<PhoneEntity> phones;
	private  List <SpecializationEntity>specialization;
	private  List <UserDataCollectionDTO> userCollection;
	

	
	public List<UserDataCollectionDTO> getUserCollection() {
		return userCollection;
	}

	public void setUserCollection(List<UserDataCollectionDTO> userCollection) {
		this.userCollection = userCollection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public String getFacbookLink() {
		return facbookLink;
	}

	public void setFacbookLink(String facbookLink) {
		this.facbookLink = facbookLink;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

//	public String getSpecializationName() {
//		return specializationName;
//	}
//
//	public void setSpecializationName(String specializationName) {
//		this.specializationName = specializationName;
//	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getWholeRetailSale() {
		return wholeRetailSale;
	}

	public void setWholeRetailSale(String wholeRetailSale) {
		this.wholeRetailSale = wholeRetailSale;
	}

	public String getDeliveryNoDelivery() {
		return deliveryNoDelivery;
	}

	public void setDeliveryNoDelivery(String deliveryNoDelivery) {
		this.deliveryNoDelivery = deliveryNoDelivery;
	}

//	public String getMobileOne() {
//		return mobileOne;
//	}
//
//	public void setMobileOne(String mobileOne) {
//		this.mobileOne = mobileOne;
//	}
//
//	public String getMobileTwo() {
//		return mobileTwo;
//	}
//
//	public void setMobileTwo(String mobileTwo) {
//		this.mobileTwo = mobileTwo;
//	}
//
//	public String getMobileThree() {
//		return mobileThree;
//	}
//
//	public void setMobileThree(String mobileThree) {
//		this.mobileThree = mobileThree;
//	}
//
//	public String getMobileFour() {
//		return mobileFour;
//	}
//
//	public void setMobileFour(String mobileFour) {
//		this.mobileFour = mobileFour;
//	}
//
//	public String getLandLineOne() {
//		return landLineOne;
//	}
//
//	public void setLandLineOne(String landLineOne) {
//		this.landLineOne = landLineOne;
//	}
//
//	public String getLandLineTwo() {
//		return landLineTwo;
//	}
//
//	public void setLandLineTwo(String landLineTwo) {
//		this.landLineTwo = landLineTwo;
//	}
//
//	public String getLandLineThree() {
//		return landLineThree;
//	}
//
//	public void setLandLineThree(String landLineThree) {
//		this.landLineThree = landLineThree;
//	}


	public List<LocationEntity> getLocations() {
		return Locations;
	}

	public void setLocations(List<LocationEntity> locations) {
		Locations = locations;
	}

	public List<PhoneEntity> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneEntity> phones) {
		this.phones = phones;
	}

	public List<SpecializationEntity> getSpecialization() {
		return specialization;
	}

	public void setSpecialization(List<SpecializationEntity> specialization) {
		this.specialization = specialization;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
}
