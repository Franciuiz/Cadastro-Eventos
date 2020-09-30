package com.example.teste.services.evento;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.teste.model.Evento;
import com.example.teste.repository.EventoRepository;

@Service
public class GetAllEventos {
	
	private final EventoRepository eventoRepository;

	public GetAllEventos(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	public List<Evento> getAll(){
		return eventoRepository.findAll();
	}	
}
