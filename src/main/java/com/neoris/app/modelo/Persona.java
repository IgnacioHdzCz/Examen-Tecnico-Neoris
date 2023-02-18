package com.neoris.app.modelo;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public   class Persona {
	
   private String nombre;
   private String genero;
   private Integer edad;
   private String identificacion;
   private String direccion;
   private String telefono;
   
}
