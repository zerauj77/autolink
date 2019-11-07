package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.Preguntas;

public interface PreguntaRepository extends CrudRepository<Preguntas, BigDecimal> {

	public Preguntas findByPregunta(String nombre);

}
