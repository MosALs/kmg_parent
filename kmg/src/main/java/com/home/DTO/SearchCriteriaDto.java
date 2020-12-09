package com.home.DTO;

import com.home.Entity.AppUser;
import com.home.Entity.Specialization;

public class SearchCriteriaDto {

	private String specializationName;
	private String areaName;
	private String governorateName;
	private String account_Type;

	public Specialization specialization;
	private AppUser appUser;

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getGovernorateName() {
		return governorateName;
	}

	public void setGovernorateName(String governorateName) {
		this.governorateName = governorateName;
	}

	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public String getAccount_Type() {
		return account_Type;
	}

	public void setAccount_Type(String account_Type) {
		this.account_Type = account_Type;
	}

}
