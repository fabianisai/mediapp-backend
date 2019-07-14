package com.fabianisai.mediappbackend.service;

import java.util.List;

import com.fabianisai.mediappbackend.model.Menu;

public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
}
