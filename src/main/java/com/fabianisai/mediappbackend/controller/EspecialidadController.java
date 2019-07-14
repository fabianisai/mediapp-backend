package com.fabianisai.mediappbackend.controller;

import java.util.List;

import com.fabianisai.mediappbackend.model.Especialidad;
import com.fabianisai.mediappbackend.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

	@Autowired
	private IEspecialidadService service;
	
	@GetMapping
	public List<Especialidad> listar() {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Especialidad listarPorId(@PathVariable("id") Integer idEspecialidad) {
		return service.leer(idEspecialidad);
	}
	
	@PostMapping
	public Especialidad registrar(@RequestBody Especialidad per) {
		return service.registrar(per);
	}
	
	@PutMapping
	public Especialidad modificar(@RequestBody Especialidad per) {
		return service.modificar(per);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer idEspecialidad) {
		service.eliminar(idEspecialidad);
	}
}
