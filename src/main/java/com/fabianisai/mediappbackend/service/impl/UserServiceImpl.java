package com.fabianisai.mediappbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fabianisai.mediappbackend.model.Usuario;
import com.fabianisai.mediappbackend.repo.IUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repo.findOneByUsername(username); // from usuario where username := username

		if (user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		user.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), roles);
		return userDetails;
	}

}
