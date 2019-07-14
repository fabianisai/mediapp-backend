package com.fabianisai.mediappbackend.service;

import com.fabianisai.mediappbackend.model.Signos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISignosService extends ICRUD<Signos>{

    Page<Signos> listarPageable(Pageable pageable);
}
