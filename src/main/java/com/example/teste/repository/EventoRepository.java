package com.example.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

}
