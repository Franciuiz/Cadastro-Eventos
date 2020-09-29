package com.example.teste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.model.Usuario;
import com.example.teste.repository.EventoRepository;
import com.example.teste.repository.UsuarioRepository;
import com.example.teste.status.UsuarioNotFoundException;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	private final UsuarioRepository usuarioRepository;
	private final EventoRepository eventoRepository;

	public UsuarioController(UsuarioRepository usuarioRepository, EventoRepository eventoRepository) {
		this.usuarioRepository = usuarioRepository;
		this.eventoRepository = eventoRepository;
	}
	
	@GetMapping("/usuario")
	public List<Usuario> getAllUsuario(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario getUsuarioById(@PathVariable(value = "id") Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Usuario", "id", id));
	}
	
	@PostMapping("/usuario")
	public Usuario setUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario updateUsuario(@PathVariable(value = "id") Long id, @Valid @RequestBody Usuario usuarioDetails) {

		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Usuario", "id", id));

		usuario.setNome(usuarioDetails.getNome());

		Usuario novoUsuario = usuarioRepository.save(usuario);
		return novoUsuario;
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable(value = "id") Long id) {

		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Usuario", "id", id));

		usuarioRepository.delete(usuario);
		return ResponseEntity.ok().build();
	}
	
	
}