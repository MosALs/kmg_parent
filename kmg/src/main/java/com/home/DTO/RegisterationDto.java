package com.home.DTO;

public class RegisterationDto {
	private int id;
	private  String firstName,lastName,mobile,gender,email,password,confirmPassword,country,gov,area,address,accountType,userAvatar;
	
	
	
	
	public RegisterationDto() {
		super();
	}
	public RegisterationDto(int id, String firstName, String lastName, String mobile, String gender, String email,
			String password, String confirmPassword, String country, String gov, String area, String address,
			String accountType, String userAvatar) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.country = country;
		this.gov = gov;
		this.area = area;
		this.address = address;
		this.accountType = accountType;
		this.userAvatar = userAvatar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	@Override
	public String toString() {
		return "RegisterationDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile="
				+ mobile + ", gender=" + gender + ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", country=" + country + ", gov=" + gov + ", area=" + area + ", address=" + address
				+ ", accountType=" + accountType + ", userAvatar=" + userAvatar + "]";
	}

	
	



}
