package com.home.util;

import org.springframework.http.HttpStatus;

public class HelperResultUtil {
	
	public static ReturnedResultModel fillResultModel(String message , String error, HttpStatus status,Object result) {
		ReturnedResultModel r = new ReturnedResultModel(message, error, status, result);
		return r;
	}

}
