package com.fabianisai.mediappbackend.repo;

import com.fabianisai.mediappbackend.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IResetTokenRepo extends JpaRepository<ResetToken, Long> {
	
	//from ResetToken where token = :?
	ResetToken findByToken(String token);

}
