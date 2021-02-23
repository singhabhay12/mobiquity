package com.mobiquityinc.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = CityNotFound.class)
	public ResponseEntity<Object> exception(CityNotFound exception) {
		return new ResponseEntity<>("City not found", HttpStatus.NOT_FOUND);
	}

}
