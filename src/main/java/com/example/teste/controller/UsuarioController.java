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
import com.example.teste.services.usuario.DeleteUsuario;
import com.example.teste.services.usuario.GetAllUsuarios;
import com.example.teste.services.usuario.GetUsuarioById;
import com.example.teste.services.usuario.SetUsuario;
import com.example.teste.services.usuario.UpdateUsuario;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	private final GetAllUsuarios serviceGetAllUsuarios;
	private final GetUsuarioById serviceGetUsuarioById;
	private final SetUsuario serviceSetUsuario;
	private final UpdateUsuario serviceUpdateUsuario;
	private final DeleteUsuario serviceDeleteUsuario;
	
	
	public UsuarioController(GetAllUsuarios serviceGetAllUsuarios, GetUsuarioById serviceGetUsuarioById,
			SetUsuario serviceSetUsuario, UpdateUsuario serviceUpdateUsuario, DeleteUsuario serviceDeleteUsuario) {
		super();
		this.serviceGetAllUsuarios = serviceGetAllUsuarios;
		this.serviceGetUsuarioById = serviceGetUsuarioById;
		this.serviceSetUsuario = serviceSetUsuario;
		this.serviceUpdateUsuario = serviceUpdateUsuario;
		this.serviceDeleteUsuario = serviceDeleteUsuario;
	}

	@GetMapping("/usuario")
	public List<Usuario> getAllUsuarios(){
		return serviceGetAllUsuarios.getAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario getUsuarioById(@PathVariable(value = "id") Long id) {
		return serviceGetUsuarioById.getById(id);
	}
	
	@PostMapping("/usuario")
	public Usuario setUsuario(@Valid @RequestBody Usuario usuario) {
		return serviceSetUsuario.set(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public Usuario updateUsuario(@PathVariable(value = "id") Long id, @Valid @RequestBody Usuario usuarioDetails) {
		return serviceUpdateUsuario.update(id, usuarioDetails);
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable(value = "id") Long id) {
		return serviceDeleteUsuario.delete(id);
	}
	
	
}