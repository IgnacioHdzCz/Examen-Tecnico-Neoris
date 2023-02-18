package com.neoris.app.service;

import java.util.List;
import java.util.Optional;

import com.neoris.app.dto.ClienteDTO;


public interface IClienteService {
	
	public List <ClienteDTO> findAll();
	public Optional<ClienteDTO> findById(Long id);
	public ClienteDTO save(ClienteDTO clienteDTO);
	public void deleteById(Long id);



}
