package com.fabianisai.mediappbackend.service;


import com.fabianisai.mediappbackend.model.Archivo;

public interface IArchivoService {

	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);
}
