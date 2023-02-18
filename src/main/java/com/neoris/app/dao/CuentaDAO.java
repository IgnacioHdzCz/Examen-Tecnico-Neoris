package com.neoris.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neoris.app.entity.Cuenta;

public interface CuentaDAO  extends JpaRepository<Cuenta, Long>{

}
