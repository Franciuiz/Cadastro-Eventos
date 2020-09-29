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

import com.example.teste.model.Evento;
import com.example.teste.repository.EventoRepository;
import com.example.teste.repository.UsuarioRepository;
import com.example.teste.status.EventoNotFoundException;

@RestController
@RequestMapping("/api")
public class EventoController {

	private final EventoRepository eventoRepository;
	private final UsuarioRepository usuarioRepository;

	public EventoController(EventoRepository eventoRepository, UsuarioRepository usuarioRepository) {
		this.eventoRepository = eventoRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/evento")
	public List<Evento> getAllEvento(){
		return eventoRepository.findAll();
	}
	
	@GetMapping("/evento/{id}")
	public Evento getEventoById(@PathVariable(value = "id") Long id) {
		return eventoRepository.findById(id)
				.orElseThrow(() -> new EventoNotFoundException("Evento", "id", id));
	}
	
	@PostMapping("/evento")
	public Evento setEvento(@Valid @RequestBody Evento evento) {
		return eventoRepository.save(evento);
	}
	
	@PutMapping("/evento/{id}")
	public Evento updatePerson(@PathVariable(value = "id") Long id, @Valid @RequestBody Evento eventoDetails) {

		Evento evento = eventoRepository.findById(id)
				.orElseThrow(() -> new EventoNotFoundException("Evento", "id", id));

		evento.setNome(eventoDetails.getNome());
		evento.setVagas(eventoDetails.getVagas());
		evento.setDataHoraInicio(eventoDetails.getDataHoraInicio());
		evento.setDataHoraFinal(eventoDetails.getDataHoraFinal());

		Evento novoEvento = eventoRepository.save(evento);
		return novoEvento;
	}
	
	@DeleteMapping("/evento/{id}")
	public ResponseEntity<Evento> deleteEvento(@PathVariable(value = "id") Long id) {

		Evento evento = eventoRepository.findById(id)
				.orElseThrow(() -> new EventoNotFoundException("Evento", "id", id));

		eventoRepository.delete(evento);
		return ResponseEntity.ok().build();
	}
	
	
}
