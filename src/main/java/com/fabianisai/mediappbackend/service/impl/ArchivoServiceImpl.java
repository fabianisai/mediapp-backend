package com.fabianisai.mediappbackend.service.impl;

import com.fabianisai.mediappbackend.model.Archivo;
import com.fabianisai.mediappbackend.repo.IArchivoRepo;
import com.fabianisai.mediappbackend.service.IArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArchivoServiceImpl implements IArchivoService {

	@Autowired
	private IArchivoRepo repo;

	@Override
	public int guardar(Archivo archivo) {
		Archivo ar = repo.save(archivo);
		return ar.getIdArchivo() > 0 ? 1 : 0;
	}

	@Override
	public byte[] leerArchivo(Integer idArchivo) {
		return repo.getOne(idArchivo).getValue();
	}

}
