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
		String errorMsg = e.getMessage();
		
		if(errorMsg == "No applicaton found") {
			error.setStatusCode(404);
		}else if(errorMsg == "No account found") {
			error.setStatusCode(404);
		}else if( errorMsg == "Invalid Credentials"){

			error.setStatusCode(401);
		}else if( errorMsg == "Unauthorised"){

			error.setStatusCode(401);
		}else {

			error.setStatusCode(500);
		}


		error.setError(e.getMessage());
		return 
				new ResponseEntity<ApiError>
		(error, HttpStatusCode.valueOf(404));
	}
}

