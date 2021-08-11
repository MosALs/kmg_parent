package com.home.DTO;

public class ShopProductUserDataDTO {

	    private String productName;
	    private String manufacturerName;
	    private Double size;
	    private String color;
	    private Integer unitPrice;
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
		@Override
		public String toString() {
			return "ShopProductUserDataDTO [productName=" + productName + ", manufacturerName=" + manufacturerName
					+ ", size=" + size + ", color=" + color + ", unitPrice=" + unitPrice + "]";
		}
	    
}
