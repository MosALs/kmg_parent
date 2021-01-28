package com.home.DTO;

public class RegisterationDto {
	private int id;
	private  String first_name,last_name,mobile,gender,email,password,country,gov,area,exact_loaction,account_type,avatar;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGov() {
		return gov;
	}
	public void setGov(String gov) {
		this.gov = gov;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getExact_loaction() {
		return exact_loaction;
	}
	public void setExact_loaction(String exact_loaction) {
		this.exact_loaction = exact_loaction;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public RegisterationDto(int id, String first_name, String last_name, String mobile, String gender, String email,
			String password, String country, String gov, String area, String exact_loaction, String account_type,
			String avatar) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.country = country;
		this.gov = gov;
		this.area = area;
		this.exact_loaction = exact_loaction;
		this.account_type = account_type;
		this.avatar = avatar;
	}
	
	    

}
