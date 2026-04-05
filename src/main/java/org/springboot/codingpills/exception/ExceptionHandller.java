package org.springboot.codingpills.exception;

import org.springboot.codingpills.entity.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandller {

	@ExceptionHandler(CompaniesNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleCNFE(CompaniesNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(null);
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StockDataNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleSDNFE(StockDataNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(null);
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
