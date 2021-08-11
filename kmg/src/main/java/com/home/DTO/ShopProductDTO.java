package com.home.DTO;

public class ShopProductDTO {

    private String productName;
    private String manufacturerName;
    private Double size;
    private String color;
    private Integer unitPrice;
    private Integer manufacturerId;
    private Integer productId;
    private Integer userId;
    private Integer shopId;
    
    
    

	public ShopProductDTO(String productName, String manufacturerName, Double size, String color,
			Integer unitPrice, Integer manufacturerId, Integer productId, Integer userId, Integer shopId) {
		super();
		this.productName = productName;
		this.manufacturerName = manufacturerName;
		this.size = size;
		this.color = color;
		this.unitPrice = unitPrice;
		this.manufacturerId = manufacturerId;
		this.productId = productId;
		this.userId = userId;
		this.shopId = shopId;
	}
	public ShopProductDTO() {
		super();
	}
	public ShopProductDTO(String productName, String manufacturerName, Double size, String color,
			Integer unitPrice, Integer manufacturerId, Integer productId, Integer shopId) {
		super();
		this.productName = productName;
		this.manufacturerName = manufacturerName;
		this.size = size;
		this.color = color;
		this.unitPrice = unitPrice;
		this.manufacturerId = manufacturerId;
		this.productId = productId;
		this.shopId = shopId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(Integer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
    
    
	
}
