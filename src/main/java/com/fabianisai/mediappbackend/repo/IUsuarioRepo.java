package com.fabianisai.mediappbackend.repo;

import com.fabianisai.mediappbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	Usuario findOneByUsername(String username);
}
