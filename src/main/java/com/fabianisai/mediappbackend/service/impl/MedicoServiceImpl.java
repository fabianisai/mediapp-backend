package com.fabianisai.mediappbackend.service.impl;

import java.util.List;

import com.fabianisai.mediappbackend.model.Medico;
import com.fabianisai.mediappbackend.repo.IMedicoRepo;
import com.fabianisai.mediappbackend.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl implements IMedicoService {

	@Autowired
	private IMedicoRepo repo;
	
	@Override
	public Medico registrar(Medico t) {
		return repo.save(t);
	}

	@Override
	public Medico modificar(Medico t) {		
		return repo.save(t);
	}

	@Override
	public Medico leer(Integer id) {		
		return repo.getOne(id);
	}

	@Override
	public List<Medico> listar() {
		return repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
