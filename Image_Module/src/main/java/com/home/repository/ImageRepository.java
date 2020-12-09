package com.home.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entity.ImageModelEntity;
@Repository
public interface ImageRepository extends JpaRepository<ImageModelEntity, Long>{
	
    Optional<ImageModelEntity> findByName(String name);
    

}
