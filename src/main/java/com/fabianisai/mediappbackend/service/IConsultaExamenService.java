package com.fabianisai.mediappbackend.service;

import java.util.List;

import com.fabianisai.mediappbackend.model.ConsultaExamen;

public interface IConsultaExamenService {

	List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta);

}
