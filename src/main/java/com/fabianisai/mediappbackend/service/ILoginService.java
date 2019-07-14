package com.fabianisai.mediappbackend.service;

import com.fabianisai.mediappbackend.model.Usuario;

public interface ILoginService {
	
	Usuario verificarNombreUsuario(String usuario) throws Exception;
	int cambiarClave(String clave, String nombre) throws Exception;

}
