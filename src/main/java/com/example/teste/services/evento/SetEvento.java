package com.example.teste.services.evento;

import org.springframework.stereotype.Service;

import com.example.teste.model.Evento;
import com.example.teste.repository.EventoRepository;

@Service 
public class SetEvento {
	
	private final EventoRepository eventoRepository;

	public SetEvento(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}
	
	public Evento set(Evento evento) {
		return eventoRepository.save(evento);
	}
}
