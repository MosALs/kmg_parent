package com.hom.image.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hom.image.entity.ImageModelEntity;
import com.hom.image.repository.ImageRepository;
@Service
public class ImageUplodeServiceImp implements ImageUplodeService {

	@Autowired

	ImageRepository imageRepository;

	@Override
	public void upLodeImage(MultipartFile file) throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);

		ImageModelEntity img = new ImageModelEntity(file.getOriginalFilename(), file.getContentType(),

				compressBytes(file.getBytes()));

		imageRepository.save(img);

	}
	
	
	@Override
	public ImageModelEntity getImage(String name) throws IOException {
		 final Optional<ImageModelEntity> retrievedImage = imageRepository.findByName(name);
	     
         ImageModelEntity img = new ImageModelEntity(retrievedImage.get().getName(), retrievedImage.get().getType(),
 
                 decompressBytes(retrievedImage.get().getPicByte()));
         return img;
	}

	public static byte[] compressBytes(byte[] data) {

		Deflater deflater = new Deflater();

		deflater.setInput(data);

		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		while (!deflater.finished()) {

			int count = deflater.deflate(buffer);

			outputStream.write(buffer, 0, count);

		}

		try {

			outputStream.close();

		} catch (IOException e) {

		}

		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();

	}

	// uncompress the image bytes before returning it to the angular application

	public static byte[] decompressBytes(byte[] data) {

		Inflater inflater = new Inflater();

		inflater.setInput(data);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		try {

			while (!inflater.finished()) {

				int count = inflater.inflate(buffer);

				outputStream.write(buffer, 0, count);

			}

			outputStream.close();

		} catch (IOException ioe) {

		} catch (DataFormatException e) {

		}

		return outputStream.toByteArray();

	}

	

}
