package com.fabianisai.mediappbackend.repo;

import com.fabianisai.mediappbackend.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IConsultaRepo extends JpaRepository<Consulta, Integer>{
    // select * from consulta c inner join paciente p on c.id_paciente =
    // p.id_paciente where p.dni = '' or p.nombres like '' or p.apellidos like '';
    @Query("from Consulta c where c.paciente.dni =:dni or LOWER(c.paciente.nombres) like %:nombreCompleto% or LOWER(c.paciente.apellidos) like %:nombreCompleto%")
    List<Consulta> buscar(@Param("dni") String dni, @Param("nombreCompleto") String nombreCompleto);

    @Query("from Consulta c where c.fecha between :fechaConsulta and :fechaSgte ")
    List<Consulta> buscarFecha(@Param("fechaConsulta") LocalDateTime fechaConsulta, @Param("fechaSgte") LocalDateTime fechaSgte);

    // MAYOR IGUAL  MENOR QUE
    // 17-05-2019
    // 17-05-2019  18-05-2019

    @Query(value = "select * from fn_listarResumen()", nativeQuery = true)
    List<Object[]>listarResumen();

    //cantidad		fecha
    //[4		,	11/05/2019]
    //[1		, 	18/05/2019]
}
