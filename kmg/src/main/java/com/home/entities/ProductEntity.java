package com.home.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "dbo", catalog = "kmgnew")
public class ProductEntity {
    private int id;
    private String productName;
    private Collection<ShopProductEntity> shopProductsById;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id == that.id &&
                Objects.equals(productName, that.productName);
    }

 

    @Basic
    @Column(name = "product_name")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
    public int hashCode() {
        return Objects.hash(id, productName);
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ShopProductEntity> getShopProductsById() {
        return shopProductsById;
    }

    public void setShopProductsById(Collection<ShopProductEntity> shopProductsById) {
        this.shopProductsById = shopProductsById;
    }
}
