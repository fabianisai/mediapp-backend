package com.fabianisai.mediappbackend.controller;

import com.fabianisai.mediappbackend.exception.ModeloNotFoundException;
import com.fabianisai.mediappbackend.model.Signos;
import com.fabianisai.mediappbackend.service.ISignosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/signos")
public class SignosController {

	@Autowired
	private ISignosService service;
	
	@GetMapping
	public ResponseEntity<List<Signos>> listar() {
		List<Signos> signosVitales = service.listar();
		return new ResponseEntity<List<Signos>>(signosVitales, HttpStatus.OK);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Signos>> listarPageable(Pageable pageable) {
		Page<Signos> signosVitales = service.listarPageable(pageable);
		return new ResponseEntity<Page<Signos>>(signosVitales, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Signos> listarPorId(@PathVariable("id") Integer idSignoVital) {
		Signos signoVital = service.leer(idSignoVital);
		if(signoVital == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + idSignoVital);
		}

		/*Resource<Paciente> resource = new Resource<Paciente>(pac);
		// localhost:8080/pacientes/{id}
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(idPaciente));
		resource.add(linkTo.withRel("paciente-resource"));*/
		return new ResponseEntity<Signos>(signoVital, HttpStatus.OK);

		//return resource;
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Signos signoVital) {
		Signos signoVitalTemp = service.registrar(signoVital);
		// localhost:8080/pacientes/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(signoVitalTemp.getIdSignos()).toUri();
		return ResponseEntity.created(location).build();
		//new ResponseEntity<Paciente>(pac,HttpStatus.CREATED)
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@Valid @RequestBody Signos signoVital) {
		service.modificar(signoVital);
		return new ResponseEntity<Object>(HttpStatus.OK);

		//object regresa vacio
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer idSigno) {
		Signos signoVital = service.leer(idSigno);
		if (signoVital == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + idSigno);
		} else {
			service.eliminar(idSigno);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
