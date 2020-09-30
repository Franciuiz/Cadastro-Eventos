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
import com.example.teste.services.evento.DeleteEvento;
import com.example.teste.services.evento.GetAllEventos;
import com.example.teste.services.evento.GetEventoById;
import com.example.teste.services.evento.SetEvento;
import com.example.teste.services.evento.UpdateEvento;

@RestController
@RequestMapping("/api")
public class EventoController {
	
	private final GetAllEventos serviceGetAllEventos;
	private final GetEventoById serviceGetEventoById;
	private final SetEvento serviceSetEvento;
	private final UpdateEvento serviceUpdateEvento;
	private final DeleteEvento serviceDeleteEvento;
	
	public EventoController(GetAllEventos serviceGetAllEventos, GetEventoById serviceGetEventoById,
			SetEvento serviceSetEvento, UpdateEvento serviceUpdateEvento, DeleteEvento serviceDeleteEvento) {
		super();
		this.serviceGetAllEventos = serviceGetAllEventos;
		this.serviceGetEventoById = serviceGetEventoById;
		this.serviceSetEvento = serviceSetEvento;
		this.serviceUpdateEvento = serviceUpdateEvento;
		this.serviceDeleteEvento = serviceDeleteEvento;
	}

	@GetMapping("/evento")
	public List<Evento> getAllEventos(){
		return serviceGetAllEventos.getAll();
	}
	
	@GetMapping("/evento/{id}")
	public Evento getEventoById(@PathVariable(value = "id") Long id) {
		return serviceGetEventoById.getById(id);
	}
	
	@PostMapping("/evento")
	public Evento setEvento(@Valid @RequestBody Evento evento) {
		return serviceSetEvento.set(evento);
	}
	
	@PutMapping("/evento/{id}")
	public Evento updateEvento(@PathVariable(value = "id") Long id, @Valid @RequestBody Evento eventoDetails) {
		return serviceUpdateEvento.update(id, eventoDetails);
	}
	
	@DeleteMapping("/evento/{id}")
	public ResponseEntity<Evento> deleteEvento(@PathVariable(value = "id") Long id) {
		return serviceDeleteEvento.delete(id);
	}
	
	
}
