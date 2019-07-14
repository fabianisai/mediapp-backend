package com.fabianisai.mediappbackend.service.impl;

import java.util.List;

import com.fabianisai.mediappbackend.model.Examen;
import com.fabianisai.mediappbackend.repo.IExamenRepo;
import com.fabianisai.mediappbackend.service.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamenServiceImpl implements IExamenService {

	@Autowired
	private IExamenRepo repo;
	
	@Override
	public Examen registrar(Examen t) {
		return repo.save(t);
	}

	@Override
	public Examen modificar(Examen t) {		
		return repo.save(t);
	}

	@Override
	public Examen leer(Integer id) {		
		return repo.getOne(id);
	}

	@Override
	public List<Examen> listar() {
		return repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
