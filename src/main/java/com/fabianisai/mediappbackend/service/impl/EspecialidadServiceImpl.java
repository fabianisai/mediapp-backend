package com.fabianisai.mediappbackend.service.impl;

import java.util.List;

import com.fabianisai.mediappbackend.model.Especialidad;
import com.fabianisai.mediappbackend.repo.IEspecialidadRepo;
import com.fabianisai.mediappbackend.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	private IEspecialidadRepo repo;
	
	@Override
	public Especialidad registrar(Especialidad t) {
		return repo.save(t);
	}

	@Override
	public Especialidad modificar(Especialidad t) {		
		return repo.save(t);
	}

	@Override
	public Especialidad leer(Integer id) {		
		return repo.getOne(id);
	}

	@Override
	public List<Especialidad> listar() {
		return repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
