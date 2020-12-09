package com.hom.image.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.hom.image.entity.ImageModelEntity;

public interface ImageUplodeService {
	
	void upLodeImage (MultipartFile file)throws IOException;
	ImageModelEntity getImage(String name) throws IOException;

}
