package com.neoris.app.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.neoris.app.modelo.Persona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7393259517288014195L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long clienteId;
	@Column(name="contraseña")
	private String contraseña;
	@Column(name="estado")
	private Boolean estado;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name = "nombre")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Cuenta> cuenta;
	
	
	
	
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
		public List<Cuenta> getCuenta() {
		return cuenta;
	}
	public void setCuenta(List<Cuenta> cuenta) {
		this.cuenta = cuenta;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	

}
