package com.oracle.finance.advice;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.oracle.finance.dto.ApiError;

//Act as catch block for the entire app
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleException(Exception e) {
		ApiError error=new ApiError();
		error.setError(e.getMessage());
		error.setStatusCode(404);
		return 
				new ResponseEntity<ApiError>
		(error, HttpStatusCode.valueOf(404));
	}
}

