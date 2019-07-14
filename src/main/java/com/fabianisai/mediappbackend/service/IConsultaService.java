package com.fabianisai.mediappbackend.service;

import com.fabianisai.mediappbackend.dto.ConsultaListaExamenDTO;
import com.fabianisai.mediappbackend.dto.ConsultaResumenDTO;
import com.fabianisai.mediappbackend.dto.FiltroConsultaDTO;
import com.fabianisai.mediappbackend.model.Consulta;

import java.util.List;


public interface IConsultaService extends ICRUD<Consulta>{
	
	Consulta registrarTransaccional(ConsultaListaExamenDTO consultaDTO);

	List<Consulta> buscar(FiltroConsultaDTO filtro);

	List<Consulta> buscarfecha(FiltroConsultaDTO filtro);

	List<ConsultaResumenDTO> listarResumen();

	byte[] generarReporte();

}
