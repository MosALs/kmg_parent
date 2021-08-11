package com.home.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.home.entities.ShopProductEntity;

@Repository
public interface ShopProductRepository extends JpaRepository<ShopProductEntity, Integer>{

	
	@Query(value = "select s from ShopProductEntity s where s.id in :shopProductIds")
	List<ShopProductEntity> findAllIn(Set<Integer> shopProductIds);
	
}
