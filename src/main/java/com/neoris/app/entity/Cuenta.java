package com.neoris.app.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6466562127112168680L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "numero_cuenta")
	private String numeroCuenta;
	@Column(name="tipo_cuenta")
	private String tipoCuenta;
	@Column(name = "saldo_inicial")
	private Long SaldoInicial;
	@Column(name="estado")
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "nombre")
	private Cliente cliente;
	
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_movimiento")
	private List<Movimiento> movimiento;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Long getSaldoInicial() {
		return SaldoInicial;
	}
	public void setSaldoInicial(Long saldoInicial) {
		SaldoInicial = saldoInicial;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
	
}
