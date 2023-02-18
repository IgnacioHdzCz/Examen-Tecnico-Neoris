package com.neoris.app.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movimientos")
public class Movimiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5331091730164085803L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="tipo_movimiento")
	private String tipoMovimiento;
	@Column(name = "valor")
	private Boolean valor;
	@Column(name = "saldo")
	private Double saldo;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cuenta cuenta;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	
	public Boolean getValor() {
		return valor;
	}
	public void setValor(Boolean valor) {
		this.valor = valor;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
