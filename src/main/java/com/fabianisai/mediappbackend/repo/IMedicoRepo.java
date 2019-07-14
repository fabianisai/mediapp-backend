package com.fabianisai.mediappbackend.repo;

import com.fabianisai.mediappbackend.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepo extends JpaRepository<Medico, Integer>{

}
