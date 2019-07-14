package com.fabianisai.mediappbackend.service;

import com.fabianisai.mediappbackend.model.ResetToken;

public interface IResetTokenService{

	ResetToken findByToken(String token);
	
	void guardar(ResetToken token);
	
	void eliminar(ResetToken token);

}
