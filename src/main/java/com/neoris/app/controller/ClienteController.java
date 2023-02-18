package com.neoris.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neoris.app.dto.ClienteDTO;
import com.neoris.app.exception.BussinesException;
import com.neoris.app.exception.RequestException;
import com.neoris.app.service.IClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService iClienteService;

	@PostMapping()
	public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
		if (clienteDTO.getNombre().equals("") || clienteDTO.getNombre() == null) {
			throw new RequestException("P-301", "Nombre requerido");
		}
		if (clienteDTO.getNombre().equals("") || clienteDTO.getNombre() == null) {
			throw new BussinesException("P-301", HttpStatus.INTERNAL_SERVER_ERROR, "Usuario ya existe");
		}
		iClienteService.save(clienteDTO);
		return new ResponseEntity(HttpStatus.CREATED).ok(clienteDTO);
	}

	@GetMapping
	public ResponseEntity<Object> getAllClientes() {
		List<ClienteDTO> listaResponseClienteDTO = iClienteService.findAll();
		if (listaResponseClienteDTO.isEmpty()) {
			throw new BussinesException("P-401", HttpStatus.INTERNAL_SERVER_ERROR, "No disponible Base de datos");
		}
		return ResponseEntity.status(HttpStatus.OK).body(iClienteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") Long id) {
		Optional<ClienteDTO> clienteDTOOptional = iClienteService.findById(id);
		if (clienteDTOOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteDTOOptional.get());
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> getUpdateCliente(@PathVariable(value = "id") Long id, @RequestBody ClienteDTO clienteDTO) {
		Optional<ClienteDTO> clienteDTOOptional = iClienteService.findById(id);
		if (clienteDTOOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
		}
		ClienteDTO updateClienteDTO = new ClienteDTO();
		updateClienteDTO.setNombre(clienteDTO.getNombre());
		updateClienteDTO.setDireccion(clienteDTO.getDireccion());
		updateClienteDTO.setContraseña(clienteDTO.getContraseña());
		updateClienteDTO.setEdad(clienteDTO.getEdad());
		updateClienteDTO.setClienteId(id);
		updateClienteDTO.setEstado(clienteDTO.getEstado());
		updateClienteDTO.setTelefono(clienteDTO.getTelefono());
		updateClienteDTO.setIdentificacion(clienteDTO.getIdentificacion());
		iClienteService.save(updateClienteDTO);
		return ResponseEntity.status(HttpStatus.OK).body(updateClienteDTO);
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") Long id){
        Optional<ClienteDTO> clienteDTOOptional = iClienteService.findById(id);
        if (clienteDTOOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
        iClienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente Eliminado");
    }

	
}