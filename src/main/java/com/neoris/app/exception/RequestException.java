package com.neoris.app.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestException extends RuntimeException {
	
	private String code;
	private String mensaje;
	
	public RequestException (String mensaje, String code) {
		this.code=code;
		this.mensaje= mensaje;
	}


	

}
