package com.example.teste.services.usuario;

import org.springframework.stereotype.Service;

import com.example.teste.model.Usuario;
import com.example.teste.repository.UsuarioRepository;
import com.example.teste.status.UsuarioNotFoundException;

@Service
public class UpdateUsuario {
	
	private final UsuarioRepository usuarioRepository;

	public UpdateUsuario(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario update(Long id, Usuario usuarioDetails) {

		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Usuario", "id", id));

		usuario.setNome(usuarioDetails.getNome());

		Usuario novoUsuario = usuarioRepository.save(usuario);
		return novoUsuario;
	}

}
