package com.hom.image.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hom.image.entity.ImageModelEntity;

public interface ImageRepository extends JpaRepository<ImageModelEntity, Long>{
	
    Optional<ImageModelEntity> findByName(String name);
    

}
