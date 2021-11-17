package com.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crudapi.model.Clientes;
import com.crudapi.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Clientes> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Clientes salvar(@RequestBody Clientes cadastro) {
		
		return clienteRepository.save(cadastro);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public Clientes delete(@RequestParam Long id) {
		
		clienteRepository.deleteById(id);
		return null;
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Clientes atualizar(@RequestParam Clientes cadastro) {
		
		return clienteRepository.saveAndFlush(cadastro);
	}
}
