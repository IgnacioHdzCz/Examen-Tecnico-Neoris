package com.neoris.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.neoris.app.dao.CuentaDAO;
import com.neoris.app.entity.Cuenta;

import com.neoris.app.service.ICuentaService;

public class CuentaServiceImpl implements ICuentaService {
	
	@Autowired
	private CuentaDAO cuentaDAO;

	@Override
	public List<Cuenta> findAll() {
		return cuentaDAO.findAll();
	}

	@Override
	public Cuenta findById(Long id) {
		return cuentaDAO.findById(id).orElse(null);
	}

	@Override
	public Cuenta save(Cuenta cuenta) {
		return cuentaDAO.save(cuenta);
	}

	@Override
	public void deleteById(Long id) {
		cuentaDAO.deleteById(id);
		
	}



}
