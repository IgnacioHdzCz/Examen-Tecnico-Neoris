package com.neoris.app.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter @Setter
public class ErrorDTO {

	private String code;
	private String mensaje;
	
}
