package com.example.teste.services.usuario;

import org.springframework.stereotype.Service;

import com.example.teste.model.Usuario;
import com.example.teste.repository.UsuarioRepository;
import com.example.teste.status.UsuarioNotFoundException;

@Service
public class GetUsuarioById {
	
	private final UsuarioRepository usuarioRepository;

	public GetUsuarioById(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario getById(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Usuario", "id", id));
	}
}
