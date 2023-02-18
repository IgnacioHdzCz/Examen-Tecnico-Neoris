package com.neoris.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.neoris.app.dto.ErrorDTO;
import com.neoris.app.exception.BussinesException;
import com.neoris.app.exception.RequestException;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException ex){
		ErrorDTO error = ErrorDTO.builder().code("Mala Peticion").mensaje(ex.getMessage()).build();
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = RequestException.class)
	public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException ex){
		ErrorDTO error = ErrorDTO.builder().code(ex.getCode()).mensaje(ex.getMessage()).build();
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = BussinesException.class)
	public ResponseEntity<ErrorDTO> bussinessExceptionHandler(BussinesException ex){
		ErrorDTO error = ErrorDTO.builder().code(ex.getCode()).mensaje(ex.getMessage()).build();
		return new ResponseEntity<>(error,ex.getStaus());
	}
}
