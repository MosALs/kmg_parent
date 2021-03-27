package com.home.util;

import com.home.DTO.RegisterationDto;

public class HelperValidationUtil {

	public static String validateDTO(RegisterationDto dto) {
		String message = " " +" "+"";
		StringBuilder builder = new StringBuilder();
		if (dto.getFirst_name() == null || dto.getFirst_name().isEmpty()) {
			message = "first name, ";
			builder.append(message);
		}
		if (dto.getLast_name() == null || dto.getLast_name().isEmpty()) {
			message = "last name";
			builder.append(message);
		}
		if (dto.getAccount_type() == null || dto.getAccount_type().isEmpty()) {
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
