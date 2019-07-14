package com.fabianisai.mediappbackend.service.impl;

import java.util.List;

import com.fabianisai.mediappbackend.model.Paciente;
import com.fabianisai.mediappbackend.model.Usuario;
import com.fabianisai.mediappbackend.repo.IPacienteRepo;
import com.fabianisai.mediappbackend.repo.IUsuarioRepo;
import com.fabianisai.mediappbackend.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepo repo;

	@Autowired
	private IUsuarioRepo repo1;

	@Autowired
	private BCryptPasswordEncoder bcrypt;


	@Override
	public Paciente registrar(Paciente t) {
		return repo.save(t);
	}

	@Override
	public Paciente modificar(Paciente t) {		
		return repo.save(t);
	}

	@Override
	public Paciente leer(Integer id) {		

		return repo.getOne(id);
	}

	@Override
	public List<Paciente> listar() {

/*		Usuario usuario = new Usuario();


		usuario.setIdUsuario(1);
		usuario.setUsername("fabian");
		usuario.setPassword(bcrypt.encode("123"));
		usuario.setEnabled(true);

		repo1.save(usuario);*/
/*
		Usuario usuario2 = new Usuario();
		usuario2.setIdUsuario(2);
		usuario2.setUsername("mito");
		usuario2.setPassword(bcrypt.encode("123"));
		usuario2.setEnabled(true);

		repo1.save(usuario2); */

		return repo.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Page<Paciente> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}

}
