package com.home.util;

import com.home.DTO.RegisterationDto;

public class HelperValidationUtil {

	public static String validateDTO(RegisterationDto dto) {
		String message = "";
		StringBuilder builder = new StringBuilder();
		if(dto.getFirst_name() == null || dto.getFirst_name().isEmpty()) {
			message = "first name, " ;
			builder.append(message);
		}
		if(dto.getLast_name() == null || dto.getLast_name().isEmpty()) {
			message = "last name" ;
			builder.append(message);
		}
		if(dto.getAccount_type() == null || dto.getAccount_type().isEmpty()) {
			message = "account type, " ;
			builder.append(message);
		}
		if(dto.getFirst_name() == null || dto.getFirst_name().isEmpty()) {
			message = "first name, " ;
			builder.append(message);
		}
		if(dto.getFirst_name() == null || dto.getFirst_name().isEmpty()) {
			message = "first name, " ;
			builder.append(message);
		}
		
		return builder.toString();
	}

}
