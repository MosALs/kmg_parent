package com.home.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.home.jsonfilter.View;

@Entity
@Table(name = "app_user", schema = "dbo", catalog = "kmgnew")
public class AppUserEntity {

	private int id;

	private String name;
	@JsonView({ View.AuthenticateInfo.class, View.SearchCriteriaInfo.class })
	private String userName;
	@JsonView(View.SearchCriteriaInfo.class)
	private String userMobile;
	@JsonView(View.SearchCriteriaInfo.class)
	private byte[] userImage;
	@JsonView(View.SearchCriteriaInfo.class)
	private String userHours;
	@JsonView(View.SearchCriteriaInfo.class)
	private String userGender;
	private String websiteLink;
	@JsonView(View.AuthenticateInfo.class)
	@NotNull
//	@Column(nullable = false)
	private String password;
	private String confirmPassword;
	private Boolean active;
//    @JsonView(View.AuthenticateInfo.class)
//    private int userRoleId;
	private String facbookLink;
	@JsonView(View.AuthenticateInfo.class)
	private UserRoleEntity userRoleByUserRoleId;
	private Collection<ShopEntity> shopsById;
//	private Collection<WorkOrderEntity> workOrdersById;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Basic
	@Column(name = "user_mobile")
	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	@Basic
	@Column(name = "user_image")
	public byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	@Basic
	@Column(name = "user_hours")
	public String getUserHours() {
		return userHours;
	}

	public void setUserHours(String userHours) {
		this.userHours = userHours;
	}

	@Basic
	@Column(name = "user_gender")
	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	@Basic
	@Column(name = "website_link")
	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	@Basic
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name = "confirm_password")
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	

	@Basic
	@Column(name = "active")
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Basic
	@Column(name = "facbook_link")
	public String getFacbookLink() {
		return facbookLink;
	}

	public void setFacbookLink(String facbookLink) {
		this.facbookLink = facbookLink;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AppUserEntity that = (AppUserEntity) o;
		return id == that.id &&
//                userRoleId == that.userRoleId &&
				Objects.equals(name, that.name) && Objects.equals(userName, that.userName)
				&& Objects.equals(userMobile, that.userMobile) && Arrays.equals(userImage, that.userImage)
				&& Objects.equals(userHours, that.userHours) && Objects.equals(userGender, that.userGender)
				&& Objects.equals(websiteLink, that.websiteLink) && Objects.equals(password, that.password)
				&& Objects.equals(facbookLink, that.facbookLink);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(id, name, userName, userMobile, userHours, userGender, websiteLink, password,
				facbookLink);
		result = 31 * result + Arrays.hashCode(userImage);
		return result;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_role_id", referencedColumnName = "id", nullable = false, updatable = false)
	public UserRoleEntity getUserRoleByUserRoleId() {
		return userRoleByUserRoleId;
	}

	public void setUserRoleByUserRoleId(UserRoleEntity userRoleByUserRoleId) {
		this.userRoleByUserRoleId = userRoleByUserRoleId;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "appUserByUserId")
	public Collection<ShopEntity> getShopsById() {
		return shopsById;
	}

	public void setShopsById(Collection<ShopEntity> shopsById) {
		this.shopsById = shopsById;
	}
//
//	@JsonIgnore
//	@OneToMany(mappedBy = "appUserByRequsetUserId")
//	public Collection<WorkOrderEntity> getWorkOrdersById() {
//		return workOrdersById;
//	}
//
//	public void setWorkOrdersById(Collection<WorkOrderEntity> workOrdersById) {
//		this.workOrdersById = workOrdersById;
//	}



}
