package com.example.teste.services.evento;

import org.springframework.stereotype.Service;

import com.example.teste.model.Evento;
import com.example.teste.repository.EventoRepository;
import com.example.teste.status.EventoNotFoundException;

@Service
public class UpdateEvento {
	
	private final EventoRepository eventoRepository;

	public UpdateEvento(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}
	
	public Evento update(Long id, Evento eventoDetails) {

		Evento evento = eventoRepository.findById(id)
				.orElseThrow(() -> new EventoNotFoundException("Evento", "id", id));

		evento.setNome(eventoDetails.getNome());
		evento.setVagas(eventoDetails.getVagas());
		evento.setDataHoraInicio(eventoDetails.getDataHoraInicio());
		evento.setDataHoraFinal(eventoDetails.getDataHoraFinal());

		Evento novoEvento = eventoRepository.save(evento);
		return novoEvento;
	}

}
