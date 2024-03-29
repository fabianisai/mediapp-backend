package com.fabianisai.mediappbackend.service.impl;

import com.fabianisai.mediappbackend.model.ResetToken;
import com.fabianisai.mediappbackend.repo.IResetTokenRepo;
import com.fabianisai.mediappbackend.service.IResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResetTokenServiceImpl implements IResetTokenService {

	@Autowired
	private IResetTokenRepo repo;

	@Override
	public ResetToken findByToken(String token) {
		return repo.findByToken(token);
	}

	@Override
	public void guardar(ResetToken token) {
		repo.save(token);

	}

	@Override
	public void eliminar(ResetToken token) { 
		repo.delete(token);
	}

}
