package com.neoris.app.service;

import java.util.List;

import com.neoris.app.entity.Cuenta;

public interface ICuentaService {


	public List <Cuenta> findAll();
	public Cuenta findById(Long id);
	public Cuenta save(Cuenta cuenta);
	public void deleteById(Long id);

}
