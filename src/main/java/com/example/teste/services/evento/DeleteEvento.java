package com.example.teste.services.evento;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.teste.model.Evento;
import com.example.teste.repository.EventoRepository;
import com.example.teste.status.EventoNotFoundException;

@Service
public class DeleteEvento {
	
	private final EventoRepository eventoRepository;

	public DeleteEvento(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}
	
	public ResponseEntity<Evento> delete(Long id) {

		Evento evento = eventoRepository.findById(id)
				.orElseThrow(() -> new EventoNotFoundException("Evento", "id", id));

		eventoRepository.delete(evento);
		return ResponseEntity.ok().build();
	}

}
