package com.home.util;

import com.home.DTO.RegisterationDto;

public class HelperValidationUtil {

	public static String validateDTO(RegisterationDto dto) {
		String message = " " +" "+"";
		StringBuilder builder = new StringBuilder();
		if (dto.getFirstName() == null || dto.getFirstName().isEmpty()) {
			message = "first name, ";
			builder.append(message);
		}
		if (dto.getLastName() == null || dto.getLastName().isEmpty()) {
			message = "last name";
			builder.append(message);
		}
		if (dto.getAccountType() == null || dto.getAccountType().isEmpty()) {
			message = "Account Type , ";
			builder.append(message);
		}
		if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
			message = "Password, ";
			builder.append(message);
		}
		if (dto.getConfirmPassword() == null || dto.getConfirmPassword().isEmpty()) {
			message = "Confirm Password, ";
			builder.append(message);
		}
		if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
			message = "Email , ";
			builder.append(message);
		}
		if(dto.getAddress()==null||dto.getAddress().isEmpty()) {
			message = "Address  , ";
			builder.append(message);
		}
		return builder.toString();
	}

}
