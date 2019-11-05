package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.PreguntasXUsuario;
import com.autolink.model.PreguntasXUsuarioKeys;

public interface UsuarioXPreguntaRepository extends CrudRepository<PreguntasXUsuario, PreguntasXUsuarioKeys> {

	public Iterable<PreguntasXUsuario> findByUsuarios_Id(BigDecimal id);
	public Iterable<PreguntasXUsuario> findByPreguntas_Id(BigDecimal id);


}
