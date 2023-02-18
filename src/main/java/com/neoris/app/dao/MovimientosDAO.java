package com.neoris.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neoris.app.entity.Movimiento;

public interface MovimientosDAO  extends JpaRepository<Movimiento, Long>{

}
