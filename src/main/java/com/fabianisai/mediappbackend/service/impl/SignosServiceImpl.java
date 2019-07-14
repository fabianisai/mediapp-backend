package com.fabianisai.mediappbackend.service.impl;

import com.fabianisai.mediappbackend.model.Signos;
import com.fabianisai.mediappbackend.repo.ISignosRepo;
import com.fabianisai.mediappbackend.service.ISignosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SignosServiceImpl implements ISignosService {

	@Autowired
	private ISignosRepo repo;

	@Override
	public Signos registrar(Signos t) {
		return repo.save(t);
	}

	@Override
	public Signos modificar(Signos t) {
		return repo.save(t);
	}

	@Override
	public Signos leer(Integer id) {

		return repo.getOne(id);
	}

	@Override
	public List<Signos> listar() {

		return repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Page<Signos> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
