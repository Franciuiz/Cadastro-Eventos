package com.example.teste.services.usuario;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.teste.model.Usuario;
import com.example.teste.repository.UsuarioRepository;

@Service
public class GetAllUsuarios {
	
	private final UsuarioRepository usuarioRepository;

	public GetAllUsuarios(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}

}
