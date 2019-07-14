package com.fabianisai.mediappbackend.service.impl;

import java.util.List;

import com.fabianisai.mediappbackend.model.ConsultaExamen;
import com.fabianisai.mediappbackend.repo.IConsultaExamenRepo;
import com.fabianisai.mediappbackend.service.IConsultaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaExamenServiceImpl implements IConsultaExamenService {
	
	@Autowired
	private IConsultaExamenRepo repo;
	
	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta) {
		return repo.listarExamenesPorConsulta(idconsulta);
	}

}
