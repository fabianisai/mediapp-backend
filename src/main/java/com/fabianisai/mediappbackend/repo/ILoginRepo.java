package com.fabianisai.mediappbackend.repo;

import com.fabianisai.mediappbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ILoginRepo extends JpaRepository<Usuario, Integer> {

	@Query("FROM Usuario us where us.username = :usuario")
	Usuario verificarNombreUsuario(@Param("usuario") String usuario) throws Exception;
	
	@Transactional   //ejecuta el commit
	@Modifying  //query sea sentencia dml
	@Query("UPDATE Usuario us SET us.password = :clave WHERE us.username = :nombre")
	void cambiarClave(@Param("clave") String clave, @Param("nombre") String nombre) throws Exception;
	
}
