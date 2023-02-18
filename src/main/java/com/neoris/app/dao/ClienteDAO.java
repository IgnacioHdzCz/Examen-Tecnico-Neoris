package com.neoris.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neoris.app.entity.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Long>{

}
