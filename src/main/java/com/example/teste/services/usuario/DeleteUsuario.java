package com.example.teste.services.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.teste.model.Usuario;
import com.example.teste.repository.UsuarioRepository;
import com.example.teste.status.UsuarioNotFoundException;

@Service
public class DeleteUsuario {
	
	private final UsuarioRepository usuarioRepository;

	public DeleteUsuario(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public ResponseEntity<Usuario> delete(@PathVariable(value = "id") Long id) {

		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Usuario", "id", id));

		usuarioRepository.delete(usuario);
		return ResponseEntity.ok().build();
	}

}
