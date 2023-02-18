package com.neoris.app.service.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.app.dao.ClienteDAO;
import com.neoris.app.dto.ClienteDTO;
import com.neoris.app.entity.Cliente;
import com.neoris.app.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ClienteDTO save(ClienteDTO clienteDTO) {		
		Cliente clienteEntity = modelMapper.map(clienteDTO, Cliente.class);
		clienteEntity = clienteDAO.save(clienteEntity);
		return modelMapper.map(clienteEntity, ClienteDTO.class);
	}

	@Override
	public List<ClienteDTO> findAll() {
		List<Cliente > listClienteEntity= clienteDAO.findAll();
		List <ClienteDTO> clienteListDTO = new ArrayList<>();
		listClienteEntity.forEach(cliente -> clienteListDTO.add(modelMapper.map(cliente, ClienteDTO.class))  );
		return  clienteListDTO;
	}

	@Override
	public Optional<ClienteDTO> findById(Long id) {
		Optional<Cliente> clienteEntity = clienteDAO.findById(id);
		if(clienteEntity.isEmpty()) {
			return Optional.empty();
		}
	ClienteDTO clienteDTO=	modelMapper.map(clienteEntity, ClienteDTO.class);
		return Optional.of(clienteDTO);
	}

	@Override
	public void deleteById(Long id) {
		clienteDAO.deleteById(id);
		
	}


	
	
	
}
