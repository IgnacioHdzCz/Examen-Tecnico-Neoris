package com.neoris.app.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class BussinesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8948423458522097314L;
	
	private String code;
	private HttpStatus staus;
	
	public BussinesException(String code,HttpStatus status,String message) {
		super(message);
		this.code=code;
		this.staus=status;
		
	}

}
