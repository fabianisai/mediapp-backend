package com.fabianisai.mediappbackend.repo;

import com.fabianisai.mediappbackend.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPacienteRepo extends JpaRepository<Paciente, Integer>{

}
