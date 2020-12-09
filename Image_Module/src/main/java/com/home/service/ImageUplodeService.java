package com.home.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.home.entity.ImageModelEntity;

public interface ImageUplodeService {
	
	ResponseEntity<ImageModelEntity> upLodeImage (MultipartFile file)throws IOException;
	ImageModelEntity getImage(String name) throws IOException;

}
