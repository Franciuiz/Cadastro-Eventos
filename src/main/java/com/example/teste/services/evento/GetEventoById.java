package com.example.teste.services.evento;

import org.springframework.stereotype.Service;

import com.example.teste.model.Evento;
import com.example.teste.repository.EventoRepository;
import com.example.teste.status.EventoNotFoundException;

@Service
public class GetEventoById {

	private final EventoRepository eventoRepository;

	public GetEventoById(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}
	
	public Evento getById(Long id) {
		return eventoRepository.findById(id)
				.orElseThrow(() -> new EventoNotFoundException("Evento", "id", id));
	}
}
