package com.neoris.app.service;

import java.util.List;

import com.neoris.app.entity.Cliente;
import com.neoris.app.entity.Movimiento;

public interface IMovimientoService {

	public List <Movimiento> findAll();
	public Movimiento findById(Long id);
	public Movimiento save(Cliente cliente);
	public void deleteById(Long id);


}
