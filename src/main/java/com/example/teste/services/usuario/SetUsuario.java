package com.example.teste.services.usuario;

import org.springframework.stereotype.Service;

import com.example.teste.model.Usuario;
import com.example.teste.repository.UsuarioRepository;

@Service
public class SetUsuario {
	
	private final UsuarioRepository usuarioRepository;

	public SetUsuario(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario set(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
