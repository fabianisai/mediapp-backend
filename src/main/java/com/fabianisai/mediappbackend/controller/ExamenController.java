package com.fabianisai.mediappbackend.controller;

import java.util.List;

import com.fabianisai.mediappbackend.exception.ModeloNotFoundException;
import com.fabianisai.mediappbackend.model.Examen;
import com.fabianisai.mediappbackend.model.Paciente;
import com.fabianisai.mediappbackend.service.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/examenes")
public class ExamenController {

	@Autowired
	private IExamenService service;
	
	@GetMapping
	public List<Examen> listar() {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Examen listarPorId(@PathVariable("id") Integer idExamen) {
		return service.leer(idExamen);
	}
	
	@PostMapping
	public Examen registrar(@RequestBody Examen ex) {
		return service.registrar(ex);
	}
	
	@PutMapping
	public Examen modificar(@RequestBody Examen ex) {
		return service.modificar(ex);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer idExamen) {
		Examen pac = service.leer(idExamen);
		if (pac == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + idExamen);
		} else {
			service.eliminar(idExamen);
		}

		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
