package com.home.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.home.entity.ImageModelEntity;
import com.home.service.ImageUplodeService;
import com.home.util.HelperResultUtil;
import com.home.util.ReturnedResultModel;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping(path = "/image")
@RequestMapping(value = "/image")
public class ImageUploadController {

	@Autowired
	private ImageUplodeService imageUplodeService;

//	@PostMapping(value = "/upload")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<?> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException,MultipartException {

		ReturnedResultModel returnedResultModel = new ReturnedResultModel();
		try {
			ResponseEntity<ImageModelEntity> i = imageUplodeService.upLodeImage(file);
			returnedResultModel = HelperResultUtil.fillResultModel("File uploaded successfully", "No Error", HttpStatus.OK, i.getBody().getName());
			return ResponseEntity.status(returnedResultModel.getStatus()).body(returnedResultModel);
		} catch (ResponseStatusException e) {
			returnedResultModel = HelperResultUtil.fillResultModel("Failed", e.getMessage(), e.getStatus(), null);
			return ResponseEntity.status(returnedResultModel.getStatus()).body(returnedResultModel);
		}
	}

	
	@GetMapping(path = { "/get/{imageName}" })
	public ImageModelEntity getImage(@PathVariable("imageName") String imageName) throws IOException {

		return imageUplodeService.getImage(imageName);

	}
}
// compress the image bytes before storing it in the database
//
//	public static byte[] compressBytes(byte[] data) {
//
//		Deflater deflater = new Deflater();
//
//		deflater.setInput(data);
//
//		deflater.finish();
//
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//
//		byte[] buffer = new byte[1024];
//
//		while (!deflater.finished()) {
//
//			int count = deflater.deflate(buffer);
//
//			outputStream.write(buffer, 0, count);
//
//		}
//
//		try {
//
//			outputStream.close();
//
//		} catch (IOException e) {
//
//		}
//
//		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//
//		return outputStream.toByteArray();
//
//	}
//
//	// uncompress the image bytes before returning it to the angular application
//
//	public static byte[] decompressBytes(byte[] data) {
//
//		Inflater inflater = new Inflater();
//
//		inflater.setInput(data);
//
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//
//		byte[] buffer = new byte[1024];
//
//		try {
//
//			while (!inflater.finished()) {
//
//				int count = inflater.inflate(buffer);
//
//				outputStream.write(buffer, 0, count);
//
//			}
//
//			outputStream.close();
//
//		} catch (IOException ioe) {
//
//		} catch (DataFormatException e) {
//
//		}
//
//		return outputStream.toByteArray();
//
//	}
