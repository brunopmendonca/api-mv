package com.mv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mv.entities.Colaborador;
import com.mv.services.ColaboradorService;

@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorService service;

	@CrossOrigin
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<Colaborador> findByCpf(@PathVariable String cpf) {
		Colaborador obj = service.findByCpf(cpf);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<Colaborador> insert(@RequestBody Colaborador obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@DeleteMapping(value = "/{cpf}")
	public ResponseEntity<Void> delete(@PathVariable String cpf) {

		service.delete(cpf);

		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@PutMapping
	public ResponseEntity<Colaborador> update(@RequestBody Colaborador entity) {
		Colaborador obj = service.update(entity);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Colaborador>> findAll() {
		List<Colaborador> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}