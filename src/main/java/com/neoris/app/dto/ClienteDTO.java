package com.neoris.app.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
	
	
	  private Long clienteId;
	  @NotBlank
	  @Size(max=32)
	   private String nombre; 
	   private String genero;
	   private Integer edad;
	   private String identificacion;
	   @NotBlank
	   @Size(max=32)
	   private String direccion;
	   @NotBlank
	   @Size(max = 10)
	   private String telefono;
	   @NotBlank
	   @Size(max=4)
	   private String contraseña;
	   
	   private Boolean estado;
	   

}
